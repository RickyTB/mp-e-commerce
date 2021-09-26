package com.programacion.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "review", schema = "public")
public class ReviewEntity extends BaseEntity {

    @NotNull
    @Column(name = "text", nullable = false)
    private String text;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;
}
