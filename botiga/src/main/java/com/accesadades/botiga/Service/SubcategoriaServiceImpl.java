package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Mappers.SubcategoriaMapper;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubcategoriaServiceImpl implements GenericService<SubcategoriaDTO, Long> {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private SubcategoriaMapper subcategoriaMapper;

    @Override
    public List<SubcategoriaDTO> findAll() {
        return subcategoriaMapper.subcategoriaToSubcategoriaDTO(subcategoriaRepository.findAll());
    }

    @Override
    public SubcategoriaDTO findByDescSubcategoria(String descSubcategoria) {

    }

}
