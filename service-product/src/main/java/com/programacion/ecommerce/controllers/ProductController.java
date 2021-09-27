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

import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.entities.ReviewEntity;
import com.programacion.ecommerce.services.ProductService;
import com.programacion.ecommerce.services.ReviewService;

@ApplicationScoped
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

  @Inject
  private ProductService productService;

  private ReviewService reviewService;

  @GET
  public List<ProductEntity> getAll() {
    List<ProductEntity> products = productService.getAll();
    return products;
  }

  @GET
  @Path("/{id}")
  public ProductEntity getOne(@PathParam("id") Integer id) {
    ProductEntity product = productService.getOne(id);
    return product;
  }

  @GET
  @Path("/{id}/reviews")
  public List<ReviewEntity> getReviews(@PathParam("id") Integer id) {
    ProductEntity product = productService.getOne(id);
    // List<ReviewEntity> listReviews = reviewService.getMany(product.getId());
    return product.getReviews();

  }

}
