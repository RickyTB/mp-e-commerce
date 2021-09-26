package com.programacion.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.programacion.ecommerce.enums.UserStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
@NamedQueries({
    @NamedQuery(name = "UserEntity.findByLogin", query = "SELECT u FROM UserEntity u WHERE u.login = :login"), })
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

  @OneToOne(mappedBy = "user")
  private CustomerEntity customer;

  public UserEntity(String login, String password, UserStatus status) {
    this.login = login;
    this.password = password;
    this.status = status;
  }
}
