package com.programacion.ecommerce.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.entities.CategoryEntity;
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

    @Override
    public List<ProductEntity> findCategory(CategoryEntity id) {
        Query sql = em.createNamedQuery("ProductEntity.findCategories").setParameter("category", id);
        // List<ProductEntity> res = sql.getResultList();

        return sql.getResultList();
    }

}
