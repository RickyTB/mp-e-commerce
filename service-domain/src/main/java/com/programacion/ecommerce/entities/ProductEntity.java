package com.programacion.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "product", schema = "public")
@NamedQueries({
        @NamedQuery(name = "ProductEntity.findCategories", query = "SELECT p FROM ProductEntity p WHERE p.category = :category"), })
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

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ReviewEntity> reviews;

}
