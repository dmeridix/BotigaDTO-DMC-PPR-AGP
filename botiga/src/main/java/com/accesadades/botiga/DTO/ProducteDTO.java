package com.accesadades.botiga.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProducteDTO {

  private String name;
  private String description;
  private String company;
  private float price;
  private long units;

  private String categoryName;
  private String categoryStatus;

  private String subcategoryName;
  private String subcategoryStatus;
}