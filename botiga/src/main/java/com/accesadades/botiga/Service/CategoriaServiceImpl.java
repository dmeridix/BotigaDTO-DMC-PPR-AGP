package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Mappers.CategoriaMapper;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements GenericService<CategoriaDTO, Long> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        return categoriaMapper.CategoriesToCategoriesDTO(result);
    }

    @Override
    public Optional<CategoriaDTO> findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(categoriaMapper::CategoriaToCategoriaDTO);
    }

    @Override
    public void save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.CategoriaDTOToCategoria(categoriaDTO);
        categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
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
        List<Categoria> result = categoriaRepository.findByDescCategoriaContainingIgnoreCase(descCategoria);
        return categoriaMapper.CategoriesToCategoriesDTO(result);
    }
    
}