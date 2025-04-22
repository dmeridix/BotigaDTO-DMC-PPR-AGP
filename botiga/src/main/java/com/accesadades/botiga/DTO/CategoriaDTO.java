package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private String descCategoria;
    private String statusCategoria;
    private List<SubcategoriaDTO> subcategoria;
    private List<ProductDTO> productos;
}
