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
    private Long id_Subcategoria;

    private String desc_Subcategoria;
    private String status_Subcategoria;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Timestamp creation_at;
    private Timestamp updated_at;

}
