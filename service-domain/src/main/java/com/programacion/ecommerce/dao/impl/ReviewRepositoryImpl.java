package com.programacion.ecommerce.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
     * @Override public ReviewEntity findByLogin(String login) {
     * TypedQuery<UserEntity> sql = em.createNamedQuery("UserEntity.findByLogin",
     * UserEntity.class).setParameter("login", login); return sql.getSingleResult();
     * }
     */

}
