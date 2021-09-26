package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.UserRepository;
import com.programacion.ecommerce.entities.UserEntity;

@ApplicationScoped
public class UserRepositoryImpl extends BaseRepository<UserEntity> implements UserRepository {
  @PersistenceContext(unitName = "ecommercePU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UserRepositoryImpl() {
    super(UserEntity.class);
  }

}
