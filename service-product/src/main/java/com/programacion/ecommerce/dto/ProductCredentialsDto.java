package com.programacion.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductCredentialsDto {
  private String login;
  private String password;
}
