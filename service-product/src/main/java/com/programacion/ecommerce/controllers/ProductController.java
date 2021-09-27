package com.programacion.ecommerce.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonString;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.entities.ReviewEntity;
import com.programacion.ecommerce.services.ProductService;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;

@ApplicationScoped
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

  @Inject
  private ProductService productService;

  @Inject
  @Claim("custom-value")
  private ClaimValue<JsonString> custom;

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
    return product.getReviews();

  }

  @GET
  @Path("/protected")
  @RolesAllowed("user")
  public String getJWTBasedValue() {
    return "Protected Resource; Custom value : " + custom.getValue();
  }

}
