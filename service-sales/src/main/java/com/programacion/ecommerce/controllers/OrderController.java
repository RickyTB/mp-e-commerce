package com.programacion.ecommerce.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonString;
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

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;

@RequestScoped
@Path("/")
@RolesAllowed("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

  @Inject
  private OrderService orderService;

  @Inject
  @Claim("upn")
  private ClaimValue<JsonString> jwtUpn;

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
  public String createOrder(InsertOrderDto order) {
    String customerId = jwtUpn.getValue().getString();
    return orderService.createOrder(order, Integer.parseInt(customerId));
  }

  @POST
  @Path("/carts")
  public CartEntity createCart() {
    System.out.println(jwtUpn.getValue());
    /*
     * InsertCartDto in = new InsertCartDto();
     * System.out.println(jwtUpn.getValue().hashCode()); return
     * orderService.createCart(in);
     */
    return null;
  }

}
