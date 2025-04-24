package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Mappers.CategoriaMapper;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Repository.ProductRepository;
import com.accesadades.botiga.Repository.SubcategoriaRepository;
@Service
public class CategoriaServiceImpl implements GenericService<CategoriaDTO, Long> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categoriaMapper.CategoriesToCategoriesDTO(categorias);
    }

    @Override
    public Optional<CategoriaDTO> findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(categoriaMapper::CategoriaToCategoriaDTO);
    }

    @Override
    public void save(CategoriaDTO categoriaDTO) {
        // Crear una nueva entidad Categoria
        Categoria categoria = new Categoria();
        categoria.setDescCategoria(categoriaDTO.getDescCategoria());
        categoria.setStatusCategoria("Activo");

        // Guardar la categoría sin asociar subcategorías ni productos
        categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }


    public void updateStatusCategoria(Long id, String newStatus) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));

        categoria.setStatusCategoria(newStatus);

        categoriaRepository.save(categoria);
    }

    public List<CategoriaDTO> findCategoriesByStatus(String statusCategoria) {
        List<Categoria> result = categoriaRepository.findByStatusCategoria(statusCategoria);
        return categoriaMapper.CategoriesToCategoriesDTO(result);
    }

    public Optional<CategoriaDTO> findCategoryByExactDescription(String descCategoria) {
        Optional<Categoria> categoria = categoriaRepository.findByDescCategoria(descCategoria);
        return categoria.map(categoriaMapper::CategoriaToCategoriaDTO);
    }

    public List<CategoriaDTO> findByDescCategoriaContaining(String descCategoria) {
        List<Categoria> categorias = categoriaRepository.findByDescCategoriaContainingWithoutRelations(descCategoria);

        return categoriaMapper.CategoriesToCategoriesDTO(categorias);
    }
}