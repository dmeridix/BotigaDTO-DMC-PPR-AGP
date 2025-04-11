package com.accesadades.botiga.DTO;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriaDTO {

    private String descSubcategoria;
    private String statusSubcategoria;
    private CategoriaDTO categoria;

}
