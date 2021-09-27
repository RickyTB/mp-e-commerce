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

import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.services.OrderService;

@ApplicationScoped
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

  @Inject
  private OrderService orderService;

  @GET
  public List<OrderEntity> getAll() {
    List<OrderEntity> categories = orderService.getAll();
    return categories;
  }

}
