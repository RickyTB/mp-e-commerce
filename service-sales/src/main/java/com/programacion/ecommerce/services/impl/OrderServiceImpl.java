package com.programacion.ecommerce.services.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.programacion.ecommerce.dao.OrderRepository;
import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.services.OrderService;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAll() {
        List<OrderEntity> listCategories = orderRepository.findAll();
        return listCategories;
    }

}
