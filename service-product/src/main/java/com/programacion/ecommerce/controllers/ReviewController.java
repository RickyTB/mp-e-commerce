package com.programacion.ecommerce.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonString;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.dto.ReviewCredentialsDto;
import com.programacion.ecommerce.entities.ReviewEntity;
import com.programacion.ecommerce.services.ReviewService;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;

@ApplicationScoped
@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController {

  @Inject
  private ReviewService reviewService;

  @Inject
  @Claim("custom-value")
  private ClaimValue<JsonString> custom;

  @POST
  public ReviewEntity create(ReviewCredentialsDto credencials) {
    ReviewEntity review = reviewService.create(credencials);
    return review;
  }

  @GET
  public List<ReviewEntity> getAlll() {
    List<ReviewEntity> Listreview = reviewService.getAll();
    return Listreview;
  }

  @GET
  @Path("/protected")
  @RolesAllowed("user")
  public String getJWTBasedValue() {
    return "Protected Resource; Custom value : " + custom.getValue();
  }

}
