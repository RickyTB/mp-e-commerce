package com.programacion.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "order", schema = "public")
public class OrderEntity extends BaseEntity {

    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;
    @NotNull
    @Column(name = "shipment_date")
    private Instant shipmentDate = Instant.now();

    @NotNull
    @Column(name = "shipment_address")
    private String shipmentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private CartEntity cart;

    // @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<OrderItemEntity> orderItems;

    public OrderEntity(BigDecimal price, OrderStatus status, String shepmentAdrress, PaymentEntity payment,
            CartEntity cart) {
        this.price = price;
        this.status = status;
        this.shipmentAddress = shepmentAdrress;
        this.payment = payment;
        this.cart = cart;

    }
}