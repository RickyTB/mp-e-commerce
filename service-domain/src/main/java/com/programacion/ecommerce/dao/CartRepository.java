package com.programacion.ecommerce.dao;

import java.util.List;

import com.programacion.ecommerce.entities.CartEntity;

public interface CartRepository {
    void create(CartEntity cart);

    void edit(CartEntity cart);

    void remove(CartEntity cart);

    CartEntity find(Object id);

    List<CartEntity> findAll();

    List<CartEntity> findRange(int[] range);

    int count();

}
