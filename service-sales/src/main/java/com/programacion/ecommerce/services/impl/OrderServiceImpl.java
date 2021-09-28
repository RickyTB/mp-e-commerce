package com.programacion.ecommerce.services.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.programacion.ecommerce.dao.CartRepository;
import com.programacion.ecommerce.dao.OrderItemRepository;
import com.programacion.ecommerce.dao.OrderRepository;
import com.programacion.ecommerce.dao.PaymentRepository;
import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.dto.InsertOrderDto;
import com.programacion.ecommerce.dto.InsertOrderItemDto;
import com.programacion.ecommerce.entities.CartEntity;

import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;
import com.programacion.ecommerce.entities.PaymentEntity;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.enums.OrderStatus;
import com.programacion.ecommerce.services.OrderService;

import io.helidon.common.reactive.Multi;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderRepository orderRepository;
    @Inject
    private PaymentRepository paymentRepository;
    @Inject
    private CartRepository cartRepository;
    @Inject
    private OrderItemRepository orderItemRepository;
    // @Inject
    // private ProductService productService;

    @Override
    public List<OrderEntity> getAll() {
        List<OrderEntity> listCategories = orderRepository.findAll();
        return listCategories;
    }

    @Override
    public List<OrderItemEntity> getDetails(Integer id) {
        OrderEntity listdetails = orderRepository.find(id);
        if (listdetails == null) {
            return null;
        }
        return listdetails.getOrderItems();
    }

    // metodo para crear crear la orden
    @Override
    public OrderEntity createOrder(InsertOrderDto order) {
        PaymentEntity paypal = paymentRepository.find(order.getPaypal());
        CartEntity cart = cartRepository.find(order.getCart());
        OrderEntity orden = new OrderEntity(order.getTotalPrice(), OrderStatus.CREATION, order.getAddress(), paypal,
                cart);
        orderRepository.create(orden);
        // CREAR LISTA DE ORDER ITEM
        order.getListOrder().stream().forEach(it -> {
            OrderItemEntity orderItem = new OrderItemEntity(it.getQuality(), it.getProductId(), orden);
            orderItemRepository.create(orderItem);
        });
        return null;
    }

    // metodo para crear el carrito
    @Override
    public CartEntity createCart(Integer id) {
        CartEntity cart = new CartEntity(id);
        cartRepository.create(cart);
        return cart;
    }

}
