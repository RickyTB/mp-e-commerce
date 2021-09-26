package com.programacion.ecommerce.services.impl;

import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.programacion.ecommerce.dao.CustomerRepository;
import com.programacion.ecommerce.dao.UserRepository;
import com.programacion.ecommerce.dto.LoginCredentialsDto;
import com.programacion.ecommerce.dto.SignupCredentialsDto;
import com.programacion.ecommerce.entities.CustomerEntity;
import com.programacion.ecommerce.entities.UserEntity;
import com.programacion.ecommerce.enums.UserStatus;
import com.programacion.ecommerce.services.AuthService;

import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

  @Inject
  private UserRepository userRepository;

  @Inject
  private CustomerRepository customerRepository;

  @Override
  @Transactional
  public UserEntity login(LoginCredentialsDto credentials) {
    UserEntity user = userRepository.findByLogin(credentials.getLogin());
    if (BCrypt.checkpw(credentials.getPassword(), user.getPassword())) {
      return user;
    }
    throw new WebApplicationException(Response.Status.UNAUTHORIZED);
  }

  @Override
  @Transactional
  public UserEntity signup(SignupCredentialsDto credentials) {
    String password = BCrypt.hashpw(credentials.getPassword(), BCrypt.gensalt());
    UserEntity user = new UserEntity(credentials.getLogin(), password, UserStatus.ACTIVE);
    userRepository.create(user);
    CustomerEntity customer = new CustomerEntity(credentials.getAddress(), credentials.getPhone(),
        credentials.getEmail(), Instant.now(), user);
    customerRepository.create(customer);
    return user;
  }

  @Override
  public String generateJWT() {
    // TODO Auto-generated method stub
    return null;
  }

}
