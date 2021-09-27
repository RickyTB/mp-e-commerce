package com.programacion.ecommerce.dao;

import java.util.List;

import com.programacion.ecommerce.entities.CategoryEntity;

public interface CategoryRepository {
    void create(CategoryEntity category);

    void edit(CategoryEntity category);

    void remove(CategoryEntity category);

    CategoryEntity find(Object id);

    List<CategoryEntity> findAll();

    List<CategoryEntity> findRange(int[] range);

    int count();

}
