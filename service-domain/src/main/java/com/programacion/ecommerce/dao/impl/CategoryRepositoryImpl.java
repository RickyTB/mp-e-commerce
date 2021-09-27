package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.CategoryRepository;
import com.programacion.ecommerce.entities.CategoryEntity;

@ApplicationScoped
public class CategoryRepositoryImpl extends BaseRepository<CategoryEntity> implements CategoryRepository {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryRepositoryImpl() {
        super(CategoryEntity.class);
    }
}
