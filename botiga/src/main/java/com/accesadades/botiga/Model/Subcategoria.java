package com.accesadades.botiga.Model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subcategoria")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Subcategoria")
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
