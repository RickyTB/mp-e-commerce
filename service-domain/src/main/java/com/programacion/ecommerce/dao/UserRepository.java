package com.programacion.ecommerce.dao;

import java.util.List;

import com.programacion.ecommerce.entities.UserEntity;

public interface UserRepository {
  void create(UserEntity user);

  void edit(UserEntity user);

  void remove(UserEntity user);

  UserEntity find(Object id);

  List<UserEntity> findAll();

  List<UserEntity> findRange(int[] range);

  int count();

  UserEntity findByLogin(String login);
}
