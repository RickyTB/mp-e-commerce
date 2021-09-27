package com.programacion.ecommerce.dao;

import com.programacion.ecommerce.entities.CategoryEntity;
import com.programacion.ecommerce.entities.ProductEntity;

import java.util.List;

public interface ProductRepository {
    void create(ProductEntity proceso);

    void edit(ProductEntity proceso);

    void remove(ProductEntity proceso);

    ProductEntity find(Object id);

    List<ProductEntity> findAll();

    List<ProductEntity> findRange(int[] range);

    int count();

    List<ProductEntity> findCategory(CategoryEntity id);

}
