package com.programacion.ecommerce.services;

import java.util.List;

import com.programacion.ecommerce.dto.ReviewDto;
import com.programacion.ecommerce.entities.ReviewEntity;

public interface ReviewService {
    ReviewEntity create(Integer productId, ReviewDto reviews);

    List<ReviewEntity> getAll();
}
