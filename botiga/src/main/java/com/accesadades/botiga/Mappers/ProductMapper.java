package com.accesadades.botiga.Mappers;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // Mapeig de Entitat Product a DTO
    @Mapping(source = "categoria.desc_Categoria", target = "categoryName")
    @Mapping(source = "categoria.status_Categoria", target = "categoryStatus")
    @Mapping(source = "subcategoria.descSubcategoria", target = "subcategoryName")
    @Mapping(source = "subcategoria.statusSubcategoria", target = "subcategoryStatus")
    ProductDTO productToProductDTO(Product product);

    // Mapeig de DTO a Entitat Product
    @Mapping(target = "product_id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "categoria.id_Categoria", ignore = true)
    @Mapping(target = "categoria.creation_at", ignore = true)
    @Mapping(target = "categoria.updated_at", ignore = true)
    @Mapping(target = "subcategoria.idSubcategoria", ignore = true)
    @Mapping(target = "subcategoria.creationAt", ignore = true)
    @Mapping(target = "subcategoria.updatedAt", ignore = true)
    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOs(List<Product> products);
    List<Product> productDTOsToProducts(List<ProductDTO> productDTOs);

}