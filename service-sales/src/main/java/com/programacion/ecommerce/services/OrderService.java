package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.entities.OrderEntity;

public interface OrderService {
    List<OrderEntity> getAll();

}
