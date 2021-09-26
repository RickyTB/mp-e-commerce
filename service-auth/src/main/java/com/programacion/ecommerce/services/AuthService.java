package com.programacion.ecommerce.services;

import com.programacion.ecommerce.dto.SignupCredentialsDto;
import com.programacion.ecommerce.entities.UserEntity;

public interface AuthService {

  void login();

  UserEntity signup(SignupCredentialsDto credentials);

  String generateJWT();

}
