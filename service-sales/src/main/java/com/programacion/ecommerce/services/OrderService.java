package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.dto.InsertOrderDto;
import com.programacion.ecommerce.entities.CartEntity;
import com.programacion.ecommerce.entities.CustomerEntity;
import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;

public interface OrderService {

    List<OrderItemEntity> getDetails(Integer id);

    List<OrderEntity> getAll();

    String createOrder(InsertOrderDto order, Integer customerId);

    CartEntity createCart(CustomerEntity customer);

}
