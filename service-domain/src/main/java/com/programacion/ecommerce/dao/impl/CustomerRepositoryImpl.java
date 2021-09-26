package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.CustomerRepository;
import com.programacion.ecommerce.entities.CustomerEntity;

@ApplicationScoped
public class CustomerRepositoryImpl extends BaseRepository<CustomerEntity> implements CustomerRepository {

  @PersistenceContext(unitName = "ecommercePU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public CustomerRepositoryImpl() {
    super(CustomerEntity.class);
  }

}
