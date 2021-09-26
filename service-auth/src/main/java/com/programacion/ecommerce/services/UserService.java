package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.entities.UserEntity;

public interface UserService {
  void create(UserEntity proceso);

  void edit(UserEntity proceso);

  void remove(UserEntity proceso);

  UserEntity find(Object id);

  List<UserEntity> findAll();

  List<UserEntity> findRange(int[] range);

  int count();
}
