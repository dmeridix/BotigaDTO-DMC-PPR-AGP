package com.accesadades.botiga.Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;
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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
@EntityListeners(AuditingEntityListener.class) // Habilita la auditoría automática
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria")
    private Long idCategoria;

    @Column(name = "desc_Categoria", nullable = false)
    private String descCategoria;

    @Column(name = "status_Categoria", nullable = false)
    private String statusCategoria;

    // Relación bidireccional con Subcategoria
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 10) // Carga las subcategorías en lotes de 10
    private List<Subcategoria> subcategoria = new ArrayList<>();

    // Relación bidireccional con Product
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 10) // Carga los productos en lotes de 10
    private List<Product> productos = new ArrayList<>();

    @CreatedDate // Marca este campo como fecha de creación
    @Column(name = "creation_at", updatable = false) // No se actualiza después de la creación
    private Timestamp creationAt;

    @LastModifiedDate // Marca este campo como fecha de última actualización
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Métodos auxiliares para manejar relaciones bidireccionales
    public void addSubcategoria(Subcategoria subcategoria) {
        this.subcategoria.add(subcategoria);
        subcategoria.setCategoria(this);
    }

    public void removeSubcategoria(Subcategoria subcategoria) {
        this.subcategoria.remove(subcategoria);
        subcategoria.setCategoria(null);
    }

    public void addProducto(Product product) {
        this.productos.add(product);
        product.setCategoria(this);
    }

    public void removeProducto(Product product) {
        this.productos.remove(product);
        product.setCategoria(null);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", descCategoria='" + descCategoria + '\'' +
                ", statusCategoria='" + statusCategoria + '\'' +
                // Excluir las listas de subcategorias y productos para evitar recursión
                '}';
    }
}