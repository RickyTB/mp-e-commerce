package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.entities.CategoryEntity;
import com.programacion.ecommerce.entities.ProductEntity;

public interface CategoryService {

  List<CategoryEntity> getAll();

  CategoryEntity getOne(Integer id);

  List<ProductEntity> getProducts(Integer id);
}
