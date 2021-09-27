package com.programacion.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

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
    private ZonedDateTime shipmentDate;

    @NotNull
    @Column(name = "shipment_address")
    private String shipmentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "order_item_id", referencedColumnName = "id")
    private OrderItemEntity orderItem;
}