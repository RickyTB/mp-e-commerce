package com.programacion.ecommerce.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.ReviewRepository;
import com.programacion.ecommerce.entities.ReviewEntity;

@ApplicationScoped
public class ReviewRepositoryImpl extends BaseRepository<ReviewEntity> implements ReviewRepository {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReviewRepositoryImpl() {
        super(ReviewEntity.class);
    }

    /*
     * @Override public List<ReviewEntity> getMany(Integer id) {
     * TypedQuery<ReviewEntity> sql = em.createNamedQuery("ReviewEntity.getMany",
     * ReviewEntity.class) .setParameter("productId", id); // List<ReviewEntity>
     * lstReview = sql.getResultList();
     * 
     * return sql.getResultList(); }
     */

}
