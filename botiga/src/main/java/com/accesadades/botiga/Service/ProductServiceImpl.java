package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Mappers.ProductMapper;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Repository.ProductRepository;
import com.accesadades.botiga.Repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements GenericService<ProductDTO, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private ProductMapper productMapper;

    // Listar todos los productos
    @Override
    public List<ProductDTO> findAll() {
        return productMapper.productsToProductDTOs(productRepository.findAll());
    }

    // Buscar producto por ID
    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id).map(productMapper::productToProductDTO);
    }

    // Guardar un producto
    @Override
    public void save(ProductDTO productDTO) {
        // Validar que la categoría exista
        Categoria categoria = categoriaRepository.findByDescCategoria(productDTO.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found with name: " + productDTO.getCategoryName()));

        // Validar que la subcategoría exista
        Subcategoria subcategoria = subcategoriaRepository.findByDescSubcategoria(productDTO.getSubcategoryName())
                .orElseThrow(() -> new RuntimeException("Subcategory not found with name: " + productDTO.getSubcategoryName()));

        // Mapear DTO a entidad
        Product product = productMapper.productDTOToProduct(productDTO);
        product.setCategory(categoria);
        product.setSubcategory(subcategoria);

        // Guardar el producto
        productRepository.save(product);
    }

    // Eliminar un producto por ID
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // Buscar productos por nombre
    public ProductDTO findProductByName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null) {
            throw new RuntimeException("Product not found with name: " + name);
        }
        return productMapper.productToProductDTO(product);
    }

    // Buscar productos por categoría
    public List<ProductDTO> findProductsByCategory(String categoryName) {
        List<Product> products = productRepository.findByCategoryDescCategoria(categoryName);
        return productMapper.productsToProductDTOs(products);
    }

    // Buscar productos por subcategoría
    public List<ProductDTO> findProductsBySubcategory(String subcategoryName) {
        List<Product> products = productRepository.findBySubcategoryDescSubcategoria(subcategoryName);
        return productMapper.productsToProductDTOs(products);
    }
}