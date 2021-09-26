package com.programacion.ecommerce.controllers;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.services.ProductService;

@ApplicationScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

  @Inject
  private ProductService productService;

  @GET
  @Path("/product")
  public List<ProductEntity> getAll() {
    List<ProductEntity> products = productService.getAll();
    return products;
  }

}
