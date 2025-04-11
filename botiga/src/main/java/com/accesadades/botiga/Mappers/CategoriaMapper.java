package com.accesadades.botiga.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Model.Categoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    // Método para convertir una entidad Categoria en un DTO CategoriaDTO
    @Mapping(target = "descCategoria", source = "categoria.descCategoria")
    @Mapping(target = "statusCategoria", source = "categoria.statusCategoria")
    @Mapping(target = "subcategoria", source = "categoria.subcategoria")
    @Mapping(target = "productos", source = "categoria.productos")
    CategoriaDTO CategoriaToCategoriaDTO(Categoria categoria);

    // Método para convertir un DTO CategoriaDTO en una entidad Categoria
    @Mapping(target = "descCategoria", source = "categoriaDTO.descCategoria")
    @Mapping(target = "statusCategoria", source = "categoriaDTO.statusCategoria")
    @Mapping(target = "subcategoria", source = "categoriaDTO.subcategoria")
    @Mapping(target = "productos", source = "categoriaDTO.productos")
    Categoria CategoriaDTOToCategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> CategoriesToCategoriesDTO(List<Categoria> categories);
}