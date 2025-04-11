package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria")
    private Long idCategoria;

    @Column(name = "desc_Categoria")
    private String descCategoria;
    @Column(name = "status_Categoria")
    private String statusCategoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Subcategoria> subcategoria;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> productos;

    private Timestamp creation_at;
    private Timestamp updated_at;

}

