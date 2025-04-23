package com.accesadades.botiga.Model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class) // Habilita l'auditoria automàtica
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

    @CreatedDate
    @Column(name = "creation_at", nullable = false)
    private Timestamp creationAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Override
    public String toString() {
        return "Subcategoria{" +
                "idSubcategoria=" + idSubcategoria +
                ", descSubcategoria='" + descSubcategoria + '\'' +
                ", statusSubcategoria='" + statusSubcategoria + '\'' +
                // Exclou la referència a la categoria per evitar la recursió
                '}';
    }
}
