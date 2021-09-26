package com.programacion.ecommerce.services.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.entities.UserEntity;
import com.programacion.ecommerce.services.BaseService;
import com.programacion.ecommerce.services.UserService;

@ApplicationScoped
public class UserServiceImpl extends BaseService<UserEntity> implements UserService {
  @PersistenceContext
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UserServiceImpl() {
    super(UserEntity.class);
  }

}
