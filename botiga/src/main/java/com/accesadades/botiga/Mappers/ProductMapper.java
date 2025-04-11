package com.accesadades.botiga.Mappers;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // Mapeig de Entitat Product a DTO
    @Mapping(source = "category.desc_Categoria", target = "categoryName")
    @Mapping(source = "category.status_Categoria", target = "categoryStatus")
    @Mapping(source = "subcategory.descSubcategoria", target = "subcategoryName")
    @Mapping(source = "subcategory.statusSubcategoria", target = "subcategoryStatus")
    ProductDTO productToProductDTO(Product product);

    // Mapeig de DTO a Entitat Product
    @Mapping(target = "product_id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "category.id_Categoria", ignore = true)
    @Mapping(target = "category.creation_at", ignore = true)
    @Mapping(target = "category.updated_at", ignore = true)
    @Mapping(target = "subcategory.idSubcategoria", ignore = true)
    @Mapping(target = "subcategory.creationAt", ignore = true)
    @Mapping(target = "subcategory.updatedAt", ignore = true)
    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOs(List<Product> products);
    List<Product> productDTOsToProducts(List<ProductDTO> productDTOs);

}