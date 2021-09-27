package com.programacion.ecommerce.dto;

import com.programacion.ecommerce.entities.ProductEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ReviewCredentialsDto {
  private Integer rating;
  private String text;
  private Integer productId;
}
