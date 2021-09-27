package com.programacion.ecommerce.dao;

import java.util.List;

import com.programacion.ecommerce.entities.OrderEntity;

public interface OrderRepository {
  void create(OrderEntity order);

  void edit(OrderEntity order);

  void remove(OrderEntity order);

  OrderEntity find(Object id);

  List<OrderEntity> findAll();

  List<OrderEntity> findRange(int[] range);

  int count();
}
