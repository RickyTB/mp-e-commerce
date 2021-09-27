package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.entities.CategoryEntity;

public interface CategoryService {

  List<CategoryEntity> getAll();

  CategoryEntity getOne(Integer id);

  String generateJWT();

}
