package com.programacion.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class InsertOrderDto {
  private String Address;
  private Integer paypal;
  private String status;
  private Integer cart;
  private Double totalPrice;
  private List<InsertOrderItemDto> listOrder;
}
