package com.accesadades.botiga.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Subcategoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubcategoriaMapper {

    SubcategoriaDTO subcategoriaToSubcategoriaDTO(Subcategoria subcategoria);
    
    Subcategoria subcategoriaDTOToSubcategoria(SubcategoriaDTO subcategoriaDTO);

    List<SubcategoriaDTO> subcategoriesToSubcategoriesDTO(List<Subcategoria> subcategorias);

    List<Subcategoria> subcategoriesDTOToSubcategories(List<SubcategoriaDTO> subcategoriaDTOs);

}
