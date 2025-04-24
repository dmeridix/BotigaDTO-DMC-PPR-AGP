package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private String descCategoria; // Descripción de la categoría
    private String statusCategoria;

}