package com.programacion.ecommerce.controllers;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.dto.InsertOrderDto;
import com.programacion.ecommerce.entities.CartEntity;
import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;
import com.programacion.ecommerce.services.OrderService;

@ApplicationScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

  @Inject
  private OrderService orderService;

  @GET
  @Path("/orders")
  public List<OrderEntity> getAll() {
    List<OrderEntity> categories = orderService.getAll();
    return categories;
  }

  @GET
  @Path("/orders/{id}/details")
  public List<OrderItemEntity> getDetails(@PathParam("id") Integer id) {
    List<OrderItemEntity> details = orderService.getDetails(id);
    return details;
  }

  @POST
  @Path("/orders")
  public OrderEntity createOrder(InsertOrderDto order) {
    return orderService.createOrder(order);
  }

  @POST
  @Path("/cart")
  public CartEntity createCart(Integer id) {
    return orderService.createCart(id);
  }

}
