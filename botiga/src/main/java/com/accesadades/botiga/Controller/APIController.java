package com.accesadades.botiga.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Service.CategoriaServiceImpl;
import com.accesadades.botiga.Service.ProductServiceImpl;
import com.accesadades.botiga.Service.SubcategoriaServiceImpl;

@RestController
@RequestMapping("/api/botiga")
public class APIController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @Autowired
    private SubcategoriaServiceImpl subcategoriaService;

    // Arrel de l’API: api/botiga
    @GetMapping
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("Welcome to the Botiga API!");
    }

    // Nou Producte: api/botiga/inserirProducte
    @PostMapping("/inserirProducte")
    public ResponseEntity<?> inserirProducte(@RequestBody ProductDTO productDTO) {
        try {
            productService.save(productDTO);
            return ResponseEntity.ok(productDTO);
        } catch (RuntimeException ex) {
            if (ex.getMessage().contains("Category not found") || ex.getMessage().contains("Subcategory not found")) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", ex.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Llistat tots els productes: api/botiga/LlistarProductes
    @GetMapping("/LlistarProductes")
    public ResponseEntity<List<ProductDTO>> llistarProductes() {
        List<ProductDTO> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    // Cerca de producte per nom: api/botiga/CercaProductes
    @GetMapping("/CercaProductes")
    public ResponseEntity<ProductDTO> cercaProductePerNom(@RequestParam String name) {
        ProductDTO product = productService.findProductByName(name);
        return ResponseEntity.ok(product);
    }

    // Modificar el preu d’un producte: api/botiga/ModificarPreu
    @PutMapping("/ModificarPreu/{id}")
    public ResponseEntity<Void> modificarPreu(
            @PathVariable Long id,
            @RequestParam float newPrice) {

        // Verificar si el producto existe
        if (productService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el producto
        }

        // Modificar el precio del producto
        productService.modificarPreu(id, newPrice);

        // Retornar una respuesta exitosa (204 No Content)
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminarProducte/{id}")
    public ResponseEntity<Void> eliminarProducte(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrarProductes")
    public ResponseEntity<List<ProductDTO>> filtrarProductes(
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String subcategoryName) {

        List<ProductDTO> products = productService.filterProducts(categoryName, subcategoryName);
        return ResponseEntity.ok(products);
    }

    // Nova Categoria: api/botiga/inserirCategoria
    @PostMapping("/inserirCategoria")
    public ResponseEntity<CategoriaDTO> inserirCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.save(categoriaDTO);
        return ResponseEntity.ok(categoriaDTO);
    }

    // Llistat totes les categories: api/botiga/LlistarCategories
    @GetMapping("/LlistarCategories")
    public ResponseEntity<List<CategoriaDTO>> llistarCategories() {
        List<CategoriaDTO> categorias = categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    // Cercar categories per descCategoria (descripció)
    @GetMapping("/CercarCategoriesPerDescripcio")
    public ResponseEntity<List<CategoriaDTO>> cercarCategoriesPerDescripcio(@RequestParam String desc) {
        List<CategoriaDTO> categories = categoriaService.findByDescCategoriaContaining(desc);

        return ResponseEntity.ok(categories);
    }

    @PutMapping("/ModificarStatusCategoria/{id}")
    public ResponseEntity<Void> modificarStatusCategoria(
            @PathVariable Long id,
            @RequestParam String newStatus) {
        categoriaService.updateStatusCategoria(id, newStatus);

        return ResponseEntity.noContent().build();
    }

    // Eliminar una categoria per ID
    @DeleteMapping("/EliminarCategoria/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (categoriaService.findById(id).isPresent()) {
            categoriaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Nova Subcategoria: api/botiga/inserirSubcategoria
    @PostMapping("/inserirSubcategoria")
    public ResponseEntity<SubcategoriaDTO> inserirSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        subcategoriaService.save(subcategoriaDTO);
        return ResponseEntity.ok(subcategoriaDTO);
    }

    // Llistat totes les Subcategories: api/botiga/LlistarSubcategories
    @GetMapping("/LlistarSubcategories")
    public ResponseEntity<List<SubcategoriaDTO>> llistarSubcategories() {
        List<SubcategoriaDTO> subcategories = subcategoriaService.findAll();
        return ResponseEntity.ok(subcategories);
    }

    // Eliminar una subcategoria per ID
    @DeleteMapping("/EliminarSubcategoria/{id}")
    public ResponseEntity<Void> eliminarSubcategoria(@PathVariable Long id) {
        if (subcategoriaService.findById(id).isPresent()) {
            subcategoriaService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }

    @PutMapping("/ModificarSubcategoria/{id}")
    public ResponseEntity<Void> modificarSubcategoria(
            @PathVariable Long id,
            @RequestBody SubcategoriaDTO subcategoriaDTO) {

        // Cerca la subcategoria existent pel seu ID
        SubcategoriaDTO existingSubcategoria = subcategoriaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategoria no trobada amb ID: " + id));

        // Actualitza les dades utilitzant els setters de l'entitat
        existingSubcategoria.setDescSubcategoria(subcategoriaDTO.getDescSubcategoria());
        existingSubcategoria.setStatusSubcategoria(subcategoriaDTO.getStatusSubcategoria());

        // Guarda els canvis directament a l'entitat existent
        subcategoriaService.save(existingSubcategoria);

        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    // Llistar subcategories per estat
    @GetMapping("/LlistarSubcategoriesPerEstat")
    public ResponseEntity<List<SubcategoriaDTO>> llistarSubcategoriesPerEstat(
            @RequestParam String status) {

        List<SubcategoriaDTO> subcategories = subcategoriaService.findByStatusSubcategoria(status);
        return ResponseEntity.ok(subcategories); // Retorna 200 OK
    }

}