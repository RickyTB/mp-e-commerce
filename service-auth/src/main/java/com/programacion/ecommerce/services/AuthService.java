package com.programacion.ecommerce.services;

import com.programacion.ecommerce.dto.LoginCredentialsDto;
import com.programacion.ecommerce.dto.SignupCredentialsDto;
import com.programacion.ecommerce.entities.UserEntity;

public interface AuthService {

  UserEntity login(LoginCredentialsDto credentials);

  UserEntity signup(SignupCredentialsDto credentials);

  String generateJWT(UserEntity user);

}
