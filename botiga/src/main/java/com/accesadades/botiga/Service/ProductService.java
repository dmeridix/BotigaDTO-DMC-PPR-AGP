package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();

    ProductDTO findProductByName(String name);

    List<ProductDTO> findProductsByCategory(String categoryName);

    void increasePrice(ProductDTO productDTO);
}
