package com.programacion.ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "cart", schema = "public")
public class CartEntity extends BaseEntity {

    @Column(name = "customer_id")
    private Integer customer;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public CartEntity(Integer customer) {
        this.customer = customer;
    }

}