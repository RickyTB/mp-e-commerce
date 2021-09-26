package com.programacion.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class UserEntity extends BaseEntity {

  @NotNull
  @Column(name = "login")
  private String login;

  @NotNull
  @Column(name = "password")
  private String password;

  @NotNull
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private UserStatus status;
}
