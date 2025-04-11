package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubcategoria;

    private String descSubcategoria;
    private String statusSubcategoria;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria")
    private List<Product> productes;

    private Timestamp creationAt;
    private Timestamp updatedAt;
}
