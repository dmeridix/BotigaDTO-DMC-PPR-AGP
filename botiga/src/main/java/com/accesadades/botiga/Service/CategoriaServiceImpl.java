package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Mappers.CategoriaMapper;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements GenericService<CategoriaDTO, Long> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        return result.stream()
                     .map(categoriaMapper::CategoriaToCategoriaDTO)
                     .collect(Collectors.toList());
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

    public List<CategoriaDTO> findCategoriesByStatus(String status_Categoria) {
        List<Categoria> result = categoriaRepository.findByStatus_Categoria(status_Categoria);
        return result.stream()
                     .map(categoriaMapper::CategoriaToCategoriaDTO)
                     .collect(Collectors.toList());
    }

    public List<CategoriaDTO> findCategoriesByDescriptionContaining(String desc_Categoria) {
        List<Categoria> result = categoriaRepository.findByDesc_CategoriaContainingIgnoreCase(desc_Categoria);
        return result.stream()
                     .map(categoriaMapper::CategoriaToCategoriaDTO)
                     .collect(Collectors.toList());
    }

    public List<CategoriaDTO> findCategoriesByDescriptionAndStatus(String desc_Categoria, String status_Categoria) {
        List<Categoria> result = categoriaRepository.findByDesc_CategoriaAndStatus_Categoria(desc_Categoria, status_Categoria);
        return result.stream()
                     .map(categoriaMapper::CategoriaToCategoriaDTO)
                     .collect(Collectors.toList());
    }
}