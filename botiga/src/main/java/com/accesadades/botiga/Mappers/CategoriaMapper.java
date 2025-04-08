package com.accesadades.botiga.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Model.Categoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    @Mapping(target = "desc_Categoria", source = "categoria.desc_Categoria")
    @Mapping(target = "status_Categoria", source = "categoria.status_Categoria")
    @Mapping(target = "subcategoria", source = "categoria.subcategoria")
    CategoriaDTO CategoriaToCategoriaDTO(Categoria categoria);

    @Mapping(target = "desc_Categoria", source = "categoriaDTO.desc_Categoria")
    @Mapping(target = "status_Categoria", source = "categoriaDTO.status_Categoria")
    @Mapping(target = "subcategoria", source = "categoriaDTO.subcategoria")
    Categoria CategoriaDTOToCategoria(CategoriaDTO categoriaDTO);

    Set<Categoria> CategoriesDTOToCategories(Set<CategoriaDTO> categoriesDTO);
    Set<CategoriaDTO> CategoriesToCategoriesDTO(Set<Categoria> categories);
}
