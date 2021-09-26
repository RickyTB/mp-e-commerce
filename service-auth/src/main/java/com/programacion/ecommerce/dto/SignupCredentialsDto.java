package com.programacion.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SignupCredentialsDto {
  private String login;
  private String password;
  private String address;
  private String phone;
  private String email;
}
