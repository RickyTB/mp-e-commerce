package com.programacion.ecommerce.services;

import java.util.List;
import java.util.Set;

import com.programacion.ecommerce.dto.InsertCartDto;
import com.programacion.ecommerce.dto.InsertOrderDto;
import com.programacion.ecommerce.dto.InsertOrderItemDto;
import com.programacion.ecommerce.entities.CartEntity;
import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;

public interface OrderService {

    List<OrderItemEntity> getDetails(Integer id);

    List<OrderEntity> getAll();

    String createOrder(InsertOrderDto order);

    CartEntity createCart(InsertCartDto cutomer);

}
