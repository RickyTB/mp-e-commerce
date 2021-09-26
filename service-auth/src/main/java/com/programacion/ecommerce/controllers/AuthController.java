package com.programacion.ecommerce.controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.dto.LoginCredentialsDto;
import com.programacion.ecommerce.dto.SignupCredentialsDto;
import com.programacion.ecommerce.entities.UserEntity;
import com.programacion.ecommerce.services.AuthService;

@ApplicationScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

  @Inject
  private AuthService authService;

  @POST
  @Path("/signup")
  public String signup(SignupCredentialsDto credentials) {
    UserEntity user = authService.signup(credentials);
    return authService.generateJWT(user);
  }

  @POST
  @Path("/login")
  public String login(LoginCredentialsDto credentials) {
    UserEntity user = authService.login(credentials);
    return authService.generateJWT(user);
  }

}
