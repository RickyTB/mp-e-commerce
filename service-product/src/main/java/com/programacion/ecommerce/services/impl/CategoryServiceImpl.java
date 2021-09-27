package com.programacion.ecommerce.services.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.programacion.ecommerce.dao.CategoryRepository;
import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.entities.CategoryEntity;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.services.CategoryService;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

  @Inject
  private CategoryRepository categoryRepository;

  @Inject
  private ProductRepository productRepository;

  @Override
  @Transactional
  public List<CategoryEntity> getAll() {
    List<CategoryEntity> listCategories = categoryRepository.findAll();
    return listCategories;
  }

  @Override
  @Transactional
  public CategoryEntity getOne(Integer id) {
    CategoryEntity category = categoryRepository.find(id);
    return category;
  }

  @Override
  @Transactional
  public List<ProductEntity> getProducts(Integer id) {
    CategoryEntity category = categoryRepository.find(id);
    List<ProductEntity> categories = productRepository.findCategory(category);
    return categories;
  }

}
