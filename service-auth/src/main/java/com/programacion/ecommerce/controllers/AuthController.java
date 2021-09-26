package com.programacion.ecommerce.controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.programacion.ecommerce.entities.*;
import com.programacion.ecommerce.services.*;

@ApplicationScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

  @Inject
  private UserService userService;

  @POST
  @Path("/signup")
  public String signup() {
    System.out.println(userService.findAll());
    return "";
  }

  @POST
  @Path("/login")
  public String login() {
    return "";
  }

}
