package com.programacion.ecommerce.controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.dto.LoginCredentialsDto;
import com.programacion.ecommerce.dto.SessionResultDto;
import com.programacion.ecommerce.dto.SignupCredentialsDto;
import com.programacion.ecommerce.dto.UserDto;
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
  public SessionResultDto signup(SignupCredentialsDto credentials) {
    UserEntity user = authService.signup(credentials);
    String accessToken = authService.generateJWT(user);
    UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getCustomer().getId());
    return new SessionResultDto(accessToken, userDto);
  }

  @POST
  @Path("/login")
  public SessionResultDto login(LoginCredentialsDto credentials) {
    UserEntity user = authService.login(credentials);
    String accessToken = authService.generateJWT(user);
    UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getCustomer().getId());
    return new SessionResultDto(accessToken, userDto);
  }

}
