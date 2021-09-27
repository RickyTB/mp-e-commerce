package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.CartRepository;
import com.programacion.ecommerce.entities.CartEntity;

@ApplicationScoped
public class CartRepositoryImpl extends BaseRepository<CartEntity> implements CartRepository {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartRepositoryImpl() {
        super(CartEntity.class);
    }
}
