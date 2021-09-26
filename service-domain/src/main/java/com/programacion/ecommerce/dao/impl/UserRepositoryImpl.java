package com.programacion.ecommerce.dao.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

  @Override
  public UserEntity findByLogin(String login) {
    TypedQuery<UserEntity> sql = em.createNamedQuery("UserEntity.findByLogin", UserEntity.class).setParameter("login",
        login);
    return sql.getSingleResult();
  }

}
