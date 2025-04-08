package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.accesadades.botiga.Model.Subcategoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private String desc_Categoria;
    private String status_Categoria;
    private List<Subcategoria> subcategoria;
}
