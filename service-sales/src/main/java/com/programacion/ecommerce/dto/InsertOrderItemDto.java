package com.programacion.ecommerce.dto;

import lombok.Data;

@Data
public class InsertOrderItemDto {
    private Integer quantity;
    private Integer productId;
}