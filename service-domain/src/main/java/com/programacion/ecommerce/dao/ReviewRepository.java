package com.programacion.ecommerce.dao;

import java.util.List;

import com.programacion.ecommerce.entities.ReviewEntity;

public interface ReviewRepository {
  void create(ReviewEntity review);

  void edit(ReviewEntity review);

  void remove(ReviewEntity review);

  ReviewEntity find(Object id);

  List<ReviewEntity> findAll();

  List<ReviewEntity> findRange(int[] range);

  int count();
}
