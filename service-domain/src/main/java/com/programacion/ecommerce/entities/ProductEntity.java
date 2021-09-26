package com.programacion.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "product", schema = "public")
public class ProductEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status;
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @NotNull
    @Column(name = "sales_counter", nullable = false)
    private Integer salesCounter;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "product_review", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "review_id"))
    private Set<ReviewEntity> reviews = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
