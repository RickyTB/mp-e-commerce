package com.programacion.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

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
    @Column(name = "shipped_date")
    private ZonedDateTime shippedDate;

    @NotNull
    @Column(name = "payment_address")
    private Long paymentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private CartEntity cart;
}