package com.accesadades.botiga.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accesadades.botiga.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    List<Product> findByNameAndPrice(String name, float price);

    List<Product> findByCategoriaDescCategoria(String categoryName);

    List<Product> findBySubcategoriaDescSubcategoria(String subcategoryName);

    @Query("SELECT p FROM Product p JOIN FETCH p.categoria JOIN FETCH p.subcategoria")
    List<Product> findAllWithRelations();

    List<Product> findByCategoriaDescCategoriaAndSubcategoriaDescSubcategoria(
            String categoryName,
            String subcategoryName);
}
