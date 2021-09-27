package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.OrderRepository;
import com.programacion.ecommerce.entities.OrderEntity;

@ApplicationScoped
public class OrderRepositoryImpl extends BaseRepository<OrderEntity> implements OrderRepository {
    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderRepositoryImpl() {
        super(OrderEntity.class);
    }

}
