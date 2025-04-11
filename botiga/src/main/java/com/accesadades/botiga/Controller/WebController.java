package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Service.ProductService;
import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private  productService;

    // Página principal
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    // Catálogo de productos
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        Set<ProductDTO> products = productService.findAll(); // Obtiene DTOs en lugar de entidades
        model.addAttribute("products", products);
        return "catalog";
    }

    // Búsqueda de productos por nombre
    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            ProductDTO product = productService.findProductByName(name); // Obtiene un DTO en lugar de una entidad
            model.addAttribute("product", product);
        }
        return "search"; // Referencia a search.html en el directorio templates
    }
}