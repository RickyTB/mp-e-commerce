package com.programacion.ecommerce.entities;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", schema = "public")
public class CustomerEntity extends BaseEntity {

  @NotNull
  @Column(name = "address")
  private String address;

  @NotNull
  @Column(name = "phone")
  private String phone;

  @NotNull
  @Email
  @Column(name = "email")
  private String email;

  @NotNull
  @Column(name = "subscription_date", nullable = false)
  private Instant subscriptionDate = Instant.now();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;
}
