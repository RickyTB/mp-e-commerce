package com.programacion.ecommerce.controllers;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.entities.CategoryEntity;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.services.CategoryService;

@ApplicationScoped
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {

  @Inject
  private CategoryService categoryService;

  @GET
  public List<CategoryEntity> getAll() {
    List<CategoryEntity> categories = categoryService.getAll();
    return categories;
  }

  @GET
  @Path("/{id}")
  public CategoryEntity getOne(@PathParam("id") Integer id) {
    CategoryEntity category = categoryService.getOne(id);
    return category;
  }

  @GET
  @Path("/{id}/products")
  public List<ProductEntity> listPorducts(@PathParam("id") Integer id) {
    List<ProductEntity> categories = categoryService.getProducts(id);
    return categories;
  }

}
