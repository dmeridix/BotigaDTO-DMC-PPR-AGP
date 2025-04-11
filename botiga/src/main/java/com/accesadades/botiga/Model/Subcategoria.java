package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subcategoria")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    private Long idSubcategoria;

    private String descSubcategoria;
    private String statusSubcategoria;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_Categoria", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria", cascade = CascadeType.ALL)
    private List<Product> productes;

    @Column(name = "creation_at", nullable = false)
    private Timestamp creationAt;
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
}
