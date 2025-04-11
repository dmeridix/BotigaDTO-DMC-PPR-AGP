package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByStatusCategoria(String statusCategoria);
    Optional<Categoria> findByDescCategoria(String descCategoria);
}