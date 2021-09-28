package com.programacion.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class InsertOrderDto {
  private String address;
  private Integer paypal;
  private String status;
  private Integer cart;
  private BigDecimal totalPrice;
  private List<InsertOrderItemDto> listOrder;
}
