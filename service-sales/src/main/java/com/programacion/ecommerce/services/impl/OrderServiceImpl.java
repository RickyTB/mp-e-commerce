package com.programacion.ecommerce.services.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.programacion.ecommerce.dao.CartRepository;
import com.programacion.ecommerce.dao.CustomerRepository;
import com.programacion.ecommerce.dao.OrderItemRepository;
import com.programacion.ecommerce.dao.OrderRepository;
import com.programacion.ecommerce.dao.PaymentRepository;
import com.programacion.ecommerce.dao.ProductRepository;
import com.programacion.ecommerce.dto.InsertOrderDto;
import com.programacion.ecommerce.entities.CartEntity;
import com.programacion.ecommerce.entities.CustomerEntity;

import javax.transaction.Transactional;

import com.programacion.ecommerce.entities.OrderEntity;
import com.programacion.ecommerce.entities.OrderItemEntity;
import com.programacion.ecommerce.entities.PaymentEntity;
import com.programacion.ecommerce.entities.ProductEntity;
import com.programacion.ecommerce.enums.OrderStatus;
import com.programacion.ecommerce.enums.PaymentStatus;
import com.programacion.ecommerce.enums.ProductStatus;
import com.programacion.ecommerce.services.OrderService;

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

    @Inject
    private CustomerRepository customerRepository;

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
    public String createOrder(InsertOrderDto order, Integer customerId) {
        // Payment
        PaymentEntity paypal = new PaymentEntity();
        paypal.setPaypalPaymentId("paypal");
        paypal.setStatus(PaymentStatus.ACCEPTED);
        paymentRepository.create(paypal);

        CustomerEntity customer = customerRepository.find(customerId);
        if (customer.getCart() == null) {
            CartEntity cart = new CartEntity();
            cart.setCustomer(customer);
            cartRepository.create(cart);
            customer.setCart(cart);
        }

        CartEntity cart = customer.getCart();

        OrderEntity orden = new OrderEntity(BigDecimal.valueOf(order.getTotalPrice()), OrderStatus.CREATION,
                customer.getAddress(), paypal, cart);
        orderRepository.create(orden);
        // CREAR LISTA DE ORDER ITEM
        order.getListOrder().stream().forEach(it -> {
            OrderItemEntity orderItem = new OrderItemEntity(it.getQuantity(), it.getProductId(), orden);
            ProductEntity product = productRepository.find(it.getProductId());
            ProductEntity product_temp = product;
            String msm;
            // editamos la cantidad de los productos
            if (product.getQuantity() < it.getQuantity() || product.getStatus() == ProductStatus.SOLD_OUT) {
                msm = "No hay cantidad suficiente para el pedido";
            } else {
                product_temp.setQuantity(product.getQuantity() - it.getQuantity());
                product_temp.setSalesCounter(product.getSalesCounter() + it.getQuantity());
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
    public CartEntity createCart(CustomerEntity customer) {
        CartEntity cart = new CartEntity(customer);
        cartRepository.create(cart);
        return cart;
    }

}
