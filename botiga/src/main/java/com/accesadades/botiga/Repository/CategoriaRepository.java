package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByStatus_Categoria(String status_Categoria);
    List<Categoria> findByDesc_CategoriaContainingIgnoreCase(String desc_Categoria);
    List<Categoria> findByDesc_CategoriaAndStatus_Categoria(String desc_Categoria, String status_Categoria);
}