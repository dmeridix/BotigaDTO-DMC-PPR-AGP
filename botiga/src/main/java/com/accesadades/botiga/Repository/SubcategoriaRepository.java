package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {

    Optional<Subcategoria> findByDescSubcategoria(String descSubcategoria);

    List<Subcategoria> findByStatusSubcategoria(String statusSubcategoria);

    void update(Subcategoria existingSubcategoria);

}
