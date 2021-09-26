package com.programacion.ecommerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.programacion.ecommerce.entities.UserEntity;

public interface UserRepository {
  void create(UserEntity proceso);

  void edit(UserEntity proceso);

  void remove(UserEntity proceso);

  UserEntity find(Object id);

  List<UserEntity> findAll();

  List<UserEntity> findRange(int[] range);

  int count();
}
