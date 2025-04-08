package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;

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
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Timestamp creationAt;
    private Timestamp updatedAt;
}
