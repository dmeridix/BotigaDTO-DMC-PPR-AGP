package com.accesadades.botiga.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Subcategoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubcategoriaMapper {

    @Mapping(target = "descSubcategoria", source = "subcategoria.descSubcategoria")
    @Mapping(target = "statusSubcategoria", source = "subcategoria.statusSubcategoria")
    @Mapping(target = "categoria", source = "subcategoria.categoria")
    SubcategoriaDTO subcategoriaToSubcategoriaDTO(Subcategoria subcategoria);

    @Mapping(target = "descSubcategoria", source = "subcategoriaDTO.descSubcategoria")
    @Mapping(target = "statusSubcategoria", source = "subcategoriaDTO.statusSubcategoria")
    @Mapping(target = "categoria", source = "subcategoriaDTO.categoria")
    Subcategoria subcategoriaDTOToSubcategoria(SubcategoriaDTO subcategoriaDTO);

    List<SubcategoriaDTO> subcategoriesToSubcategoriesDTO(List<Subcategoria> subcategorias);

    List<Subcategoria> subcategoriesDTOToSubcategories(List<SubcategoriaDTO> subcategoriaDTOs);

}
