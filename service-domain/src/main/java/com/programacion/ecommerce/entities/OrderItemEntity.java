package com.programacion.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "order_item", schema = "public")
@NamedQueries({
        @NamedQuery(name = "OrderItemEntity.findOrder", query = "SELECT p FROM OrderItemEntity p WHERE p.order = :order"), })

public class OrderItemEntity extends BaseEntity {

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity order;

}
