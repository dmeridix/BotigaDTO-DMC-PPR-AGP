package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private String descCategoria;
    private String statusCategoria;
    private List<Subcategoria> subcategoria;
    private List<Product> productos;
}
