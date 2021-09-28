package com.programacion.ecommerce.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.programacion.ecommerce.dao.BaseRepository;
import com.programacion.ecommerce.dao.OrderItemRepository;
import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;

@ApplicationScoped
public class OrderItemRepositoryImpl extends BaseRepository<OrderItemEntity> implements OrderItemRepository {

  @PersistenceContext(unitName = "ecommercePU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public OrderItemRepositoryImpl() {
    super(OrderItemEntity.class);
  }

  @Override
  public List<OrderItemEntity> findOrder(OrderEntity id) {
    Query sql = em.createNamedQuery("OrderItemEntity.findOrder").setParameter("order", id);
    // List<ProductEntity> res = sql.getResultList();
    return sql.getResultList();
  }

}
