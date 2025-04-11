package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Service.ProductServiceImpl;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ProductServiceImpl productService; // Injectem la implementació del servei

    // Pàgina principal
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    // Catàleg de productes
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        List<ProductDTO> products = productService.findAll(); // Obtenim DTOs des del servei
        model.addAttribute("products", products);
        return "catalog";
    }

    // Cerca de productes per nom
    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            try {
                ProductDTO product = productService.findProductByName(name); // Obtenim un DTO en lloc d'una entitat
                model.addAttribute("product", product);
            } catch (RuntimeException e) {
                // Si no es troba el producte, podem mostrar un missatge d'error
                model.addAttribute("errorMessage", "No s'ha trobat cap producte amb el nom: " + name);
            }
        }
        return "search"; // Referència a search.html en el directori templates
    }
}
