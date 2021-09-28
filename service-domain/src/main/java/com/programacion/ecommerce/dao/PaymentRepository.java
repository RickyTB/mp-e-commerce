package com.programacion.ecommerce.dao;

import com.programacion.ecommerce.entities.PaymentEntity;

import java.util.List;

public interface PaymentRepository {
    void create(PaymentEntity payment);

    void edit(PaymentEntity payment);

    void remove(PaymentEntity payment);

    PaymentEntity find(Object id);

    List<PaymentEntity> findAll();

    List<PaymentEntity> findRange(int[] range);

    int count();

}
