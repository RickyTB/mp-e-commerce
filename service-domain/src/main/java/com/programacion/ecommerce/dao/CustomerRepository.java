package com.programacion.ecommerce.dao;

import java.util.List;

import com.programacion.ecommerce.entities.CustomerEntity;

public interface CustomerRepository {
  void create(CustomerEntity customer);

  void edit(CustomerEntity customer);

  void remove(CustomerEntity customer);

  CustomerEntity find(Object id);

  List<CustomerEntity> findAll();

  List<CustomerEntity> findRange(int[] range);

  int count();
}
