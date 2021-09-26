package com.programacion.ecommerce.services.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.programacion.ecommerce.dao.UserRepository;
import com.programacion.ecommerce.dto.SignupCredentialsDto;
import com.programacion.ecommerce.entities.UserEntity;
import com.programacion.ecommerce.enums.UserStatus;
import com.programacion.ecommerce.services.AuthService;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

  @Inject
  private UserRepository userRepository;

  @Override
  @Transactional
  public void login() {
    // TODO Auto-generated method stub

  }

  @Override
  @Transactional
  public UserEntity signup(SignupCredentialsDto credentials) {
    UserEntity user = new UserEntity(credentials.getLogin(), credentials.getPassword(), UserStatus.ACTIVE);
    userRepository.create(user);
    return user;
  }

  @Override
  public String generateJWT() {
    // TODO Auto-generated method stub
    return null;
  }

}
