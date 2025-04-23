package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

  private String name;
  private String description;
  private String company;
  private float price;
  private long units;

  private String category;

  private String subcategory;
}