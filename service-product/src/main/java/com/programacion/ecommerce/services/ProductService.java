package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.entities.ProductEntity;

public interface ProductService {

  List<ProductEntity> getAll();

  ProductEntity getOne(Integer id);
}
