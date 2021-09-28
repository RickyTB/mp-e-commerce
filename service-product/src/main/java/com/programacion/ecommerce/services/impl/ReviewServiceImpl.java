package com.programacion.ecommerce.services.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.dao.ReviewRepository;
import com.programacion.ecommerce.dto.ReviewDto;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.entities.ReviewEntity;
import com.programacion.ecommerce.services.ReviewService;

@ApplicationScoped
public class ReviewServiceImpl implements ReviewService {

    @Inject
    private ReviewRepository reviewRepository;

    @Inject
    private ProductRepository productRepository;

    @Override
    @Transactional
    public ReviewEntity create(Integer productId, ReviewDto rev) {
        ProductEntity product = productRepository.find(productId);
        ReviewEntity review = new ReviewEntity(rev.getText(), rev.getRating(), product);
        reviewRepository.create(review);
        return review;
    }

    /*
     * @Override
     * 
     * @Transactional public List<ReviewEntity> getMany(Integer id) {
     * List<ReviewEntity> listReviews = reviewRepository.getMany(id); return
     * listReviews; }
     */

    @Override
    @Transactional
    public List<ReviewEntity> getAll() {
        List<ReviewEntity> listReviews = reviewRepository.findAll();
        return listReviews;
    }

}
