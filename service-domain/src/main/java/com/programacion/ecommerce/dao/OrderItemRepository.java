package com.programacion.ecommerce.dao;

import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;

import java.util.List;

public interface OrderItemRepository {
    void create(OrderItemEntity orderItem);

    void edit(OrderItemEntity orderItem);

    void remove(OrderItemEntity orderItem);

    OrderItemEntity find(Object id);

    List<OrderItemEntity> findAll();

    List<OrderItemEntity> findRange(int[] range);

    int count();

    List<OrderItemEntity> findOrder(OrderEntity id);

}
