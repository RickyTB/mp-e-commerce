package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.dto.ReviewCredentialsDto;
import com.programacion.ecommerce.entities.ReviewEntity;

public interface ReviewService {

    ReviewEntity create(ReviewCredentialsDto reviews);

    List<ReviewEntity> getAll();

    String generateJWT();
}
