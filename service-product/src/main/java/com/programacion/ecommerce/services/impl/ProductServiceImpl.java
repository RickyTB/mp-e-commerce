package com.programacion.ecommerce.services.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.programacion.ecommerce.dao.ProductRepository;

import com.programacion.ecommerce.entities.ProductEntity;

import com.programacion.ecommerce.services.ProductService;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

  @Inject
  private ProductRepository productRepository;

  @Override
  public List<ProductEntity> getAll() {
    List<ProductEntity> listProduct = productRepository.findAll();
    return listProduct;
  }

  @Override
  public ProductEntity getOne(Integer id) {
    ProductEntity product = productRepository.find(id);
    return product;
  }

}
