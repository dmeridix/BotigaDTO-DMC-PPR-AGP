package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {

    // Método para buscar una subcategoría por su descripción
    Optional<Subcategoria> findByDescSubcategoria(String descSubcategoria);

    // Puedes agregar más métodos personalizados según lo necesites

}
