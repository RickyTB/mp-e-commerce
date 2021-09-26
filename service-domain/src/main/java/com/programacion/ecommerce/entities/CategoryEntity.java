package com.programacion.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "category", schema = "public")
public class CategoryEntity extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
}
