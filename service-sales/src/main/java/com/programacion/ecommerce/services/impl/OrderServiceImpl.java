package com.programacion.ecommerce.services.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.programacion.ecommerce.dao.CartRepository;
import com.programacion.ecommerce.dao.OrderItemRepository;
import com.programacion.ecommerce.dao.OrderRepository;
import com.programacion.ecommerce.dao.PaymentRepository;
import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.dto.InsertCartDto;
import com.programacion.ecommerce.dto.InsertOrderDto;
import com.programacion.ecommerce.dto.InsertOrderItemDto;
import com.programacion.ecommerce.entities.CartEntity;

import javax.transaction.Transactional;

import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;
import com.programacion.ecommerce.entities.PaymentEntity;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.enums.OrderStatus;
import com.programacion.ecommerce.enums.ProductStatus;
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
    @Inject
    private ProductRepository productRepository;

    @Override
    public List<OrderEntity> getAll() {
        List<OrderEntity> listCategories = orderRepository.findAll();
        return listCategories;
    }

    @Override
    public List<OrderItemEntity> getDetails(Integer id) {
        OrderEntity order = orderRepository.find(id);
        List<OrderItemEntity> listdetails = orderItemRepository.findOrder(order);
        if (listdetails == null) {
            return null;
        }
        return listdetails;
    }

    // metodo para crear crear la orden
    @Override
    @Transactional
    public String createOrder(InsertOrderDto order) {
        PaymentEntity paypal = paymentRepository.find(order.getPaypal());
        CartEntity cart = cartRepository.find(order.getCart());
        OrderEntity orden = new OrderEntity(order.getTotalPrice(), OrderStatus.CREATION, order.getAddress(), paypal,
                cart);
        orderRepository.create(orden);
        // CREAR LISTA DE ORDER ITEM
        order.getListOrder().stream().forEach(it -> {
            OrderItemEntity orderItem = new OrderItemEntity(it.getQuality(), it.getProductId(), orden);
            ProductEntity product = productRepository.find(it.getProductId());
            ProductEntity product_temp = product;
            String msm;
            // editamos la cantidad de los productos
            if (product.getQuantity() < it.getQuality() || product.getStatus() == ProductStatus.SOLD_OUT) {
                msm = "No hay cantidad suficiente para el pedido";
            } else {
                product_temp.setQuantity(product.getQuantity() - it.getQuality());
                product_temp.setSalesCounter(product.getSalesCounter() + it.getQuality());
                if (product_temp.getQuantity() == 0) {
                    product_temp.setStatus(ProductStatus.SOLD_OUT);
                }
                productRepository.edit(product_temp);
                msm = "producto editado con exito ...";
                orderItemRepository.create(orderItem);
            }
        });
        return null;
    }

    // metodo para crear el carrito
    @Override
    @Transactional
    public CartEntity createCart(InsertCartDto cutomer) {
        CartEntity cart = new CartEntity(cutomer.getCustomer());
        cartRepository.create(cart);
        return cart;
    }

}
