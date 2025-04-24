package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Mappers.SubcategoriaMapper;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoriaServiceImpl implements GenericService<SubcategoriaDTO, Long> {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SubcategoriaMapper subcategoriaMapper;

    @Override
    public List<SubcategoriaDTO> findAll() {
        return subcategoriaMapper.subcategoriesToSubcategoriesDTO(subcategoriaRepository.findAll());
    }

    @Override
    public Optional<SubcategoriaDTO> findById(Long id) {
        Optional<Subcategoria> subcategoria = subcategoriaRepository.findById(id);
        return subcategoria.map(subcategoriaMapper::subcategoriaToSubcategoriaDTO);
    }

    @Override
    public void save(SubcategoriaDTO subcategoriaDTO) {
        // Cerca la categoria pel nom
        Categoria categoria = categoriaRepository.findByDescCategoria(subcategoriaDTO.getDescCategoria())
                .orElseThrow(() -> new RuntimeException(
                        "Categoria no trobada amb nom: " + subcategoriaDTO.getDescCategoria()));

        // Crea una nova subcategoria
        Subcategoria subcategoria = subcategoriaMapper.subcategoriaDTOToSubcategoria(subcategoriaDTO);
        subcategoria.setCategoria(categoria); // Assigna la categoria trobada

        // Guarda la subcategoria
        subcategoriaRepository.save(subcategoria);
    }

    @Override
    public void deleteById(Long id) {
        subcategoriaRepository.deleteById(id);
    }

    public Optional<SubcategoriaDTO> findByDescSubcategoria(String descSubcategoria) {
        Optional<Subcategoria> subcategoria = subcategoriaRepository.findByDescSubcategoria(descSubcategoria);
        return subcategoria.map(subcategoriaMapper::subcategoriaToSubcategoriaDTO);
    }

    public List<SubcategoriaDTO> findByStatusSubcategoria(String statusSubcategoria) {
        List<Subcategoria> subcategorias = subcategoriaRepository.findByStatusSubcategoria(statusSubcategoria);
        return subcategoriaMapper.subcategoriesToSubcategoriesDTO(subcategorias);
    }

}