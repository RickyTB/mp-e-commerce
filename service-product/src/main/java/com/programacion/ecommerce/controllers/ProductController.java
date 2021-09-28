package com.programacion.ecommerce.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.dto.ReviewDto;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.entities.ReviewEntity;
import com.programacion.ecommerce.services.ProductService;
import com.programacion.ecommerce.services.ReviewService;

@RequestScoped
@Path("/products")
@PermitAll
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

  @Inject
  private ProductService productService;

  @Inject
  private ReviewService reviewService;

  @GET
  public List<ProductEntity> getAll() {
    List<ProductEntity> products = productService.getAll();
    return products.stream().map(p -> {
      p.setReviews(null);
      return p;
    }).collect(Collectors.toList());
  }

  @GET
  @Path("/{id}")
  public ProductEntity getOne(@PathParam("id") Integer id) {
    ProductEntity product = productService.getOne(id);
    product.setReviews(null);
    return product;
  }

  @GET
  @Path("/{id}/reviews")
  public List<ReviewEntity> getReviews(@PathParam("id") Integer id) {
    ProductEntity product = productService.getOne(id);
    return product.getReviews().stream().map(r -> {
      r.setProduct(null);
      return r;
    }).collect(Collectors.toList());
  }

  @POST
  @RolesAllowed("user")
  @Path("/{id}/reviews")
  public ReviewEntity createReview(@PathParam("id") Integer id, ReviewDto reviewDto) {
    ReviewEntity review = reviewService.create(id, reviewDto);
    review.setProduct(null);
    return review;
  }
}
