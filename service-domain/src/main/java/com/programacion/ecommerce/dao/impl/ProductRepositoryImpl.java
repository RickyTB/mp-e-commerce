package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.entities.ProductEntity;

@ApplicationScoped
public class ProductRepositoryImpl extends BaseRepository<ProductEntity> implements ProductRepository {
    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductRepositoryImpl() {
        super(ProductEntity.class);
    }
}
