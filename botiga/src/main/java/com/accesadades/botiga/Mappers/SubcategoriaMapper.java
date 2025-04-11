package com.accesadades.botiga.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Subcategoria;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubcategoriaMapper {

    @Mapping(source = "categoria.nomCategoria", target = "nomCategoria") // Mapeig de la categoria
    SubcategoriaDTO subcategoriaToSubcategoriaDTO(Subcategoria subcategoria);
}
