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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.programacion.ecommerce.dto.ReviewDto;
import com.programacion.ecommerce.entities.ReviewEntity;
import com.programacion.ecommerce.services.ReviewService;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;

@RequestScoped
@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController {

  @Inject
  private ReviewService reviewService;

  @Inject
  @Claim("iss")
  private ClaimValue<JsonString> jwtIss;

  @POST
  @RolesAllowed("user")
  public ReviewEntity create(ReviewDto reviewDto) {
    System.out.println(jwtIss.getValue());
    return null;
    // ReviewEntity review = reviewService.create(credencials);
    // return review;
  }

  @GET
  public List<ReviewEntity> getAlll() {
    List<ReviewEntity> Listreview = reviewService.getAll();
    return Listreview;
  }

}
