package com.accesadades.botiga.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    // Mapeig de Entitat Product a DTO
    ProductDTO productToProductDTO(Product product);

    // Mapeig de DTO a Entitat Product
    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOs(List<Product> products);
    List<Product> productDTOsToProducts(List<ProductDTO> productDTOs);

}