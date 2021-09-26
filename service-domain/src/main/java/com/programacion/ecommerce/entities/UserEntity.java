package com.programacion.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

  @Column(name = "login", nullable = false)
  private String login;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "status", nullable = false)
  private Integer status;
}
