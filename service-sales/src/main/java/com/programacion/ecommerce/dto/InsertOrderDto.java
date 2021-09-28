package com.programacion.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class InsertOrderDto {
  private Double totalPrice;
  private List<InsertOrderItemDto> listOrder;
}
