package com.accesadades.botiga.Model;

import java.io.Serializable;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) // Habilita la auditoría automática
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria")
    private Long idCategoria;

    @Column(name = "desc_Categoria", nullable = false)
    private String descCategoria;

    @Column(name = "status_Categoria", nullable = false)
    private String statusCategoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Subcategoria> subcategoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Product> productos;

    @CreatedDate // Marca este campo como fecha de creación
    @Column(name = "creation_at", updatable = false) // No se actualiza después de la creación
    private Timestamp creationAt;

    @LastModifiedDate // Marca este campo como fecha de última actualización
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}