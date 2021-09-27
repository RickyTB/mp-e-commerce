package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.PaymentRepository;
import com.programacion.ecommerce.entities.PaymentEntity;

@ApplicationScoped
public class PaymentRepositoryImpl extends BaseRepository<PaymentEntity> implements PaymentRepository {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentRepositoryImpl() {
        super(PaymentEntity.class);
    }
}
