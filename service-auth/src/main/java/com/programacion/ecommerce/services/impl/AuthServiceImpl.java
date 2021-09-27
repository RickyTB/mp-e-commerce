package com.programacion.ecommerce.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;
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
import com.programacion.ecommerce.secure.MPJWTToken;
import com.programacion.ecommerce.services.AuthService;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mindrot.jbcrypt.BCrypt;

import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

  private String key;

  @Inject
  private UserRepository userRepository;

  @Inject
  private CustomerRepository customerRepository;

  @Inject
  @ConfigProperty(name = "mp.jwt.verify.issuer")
  private String jwtIss;

  @PostConstruct
  public void init() {
    key = readPemFile();
  }

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
    user.setCustomer(customer);
    return user;
  }

  @Override
  public String generateJWT(UserEntity user) {
    JWTAuth provider = JWTAuth.create(null,
        new JWTAuthOptions().addPubSecKey(new PubSecKeyOptions().setAlgorithm("RS256").setSecretKey(key)));

    MPJWTToken token = new MPJWTToken();
    token.setAud("targetService");
    token.setIss(jwtIss); // Must match the expected issues configuration values
    token.setJti(UUID.randomUUID().toString());
    token.setSub("" + user.getId()); // Sub is required for WildFly Swarm
    token.setUpn("" + user.getCustomer().getId());
    token.setIat(System.currentTimeMillis());
    token.setExp(System.currentTimeMillis() + (3600 * 1000)); // 30 Seconds expiration!
    // token.addAdditionalClaims("custom-value", "Jessie specific value");
    token.setGroups(Arrays.asList("user"));

    return provider.generateToken(new io.vertx.core.json.JsonObject().mergeIn(token.toJSONString()),
        new JWTOptions().setAlgorithm("RS256"));
  }

  // NOTE: Expected format is PKCS#8 (BEGIN PRIVATE KEY) NOT PKCS#1 (BEGIN RSA
  // PRIVATE KEY)
  // See gencerts.sh
  private static String readPemFile() {
    StringBuilder sb = new StringBuilder(8192);
    try (BufferedReader is = new BufferedReader(new InputStreamReader(
        AuthServiceImpl.class.getResourceAsStream("/privateKey.pem"), StandardCharsets.US_ASCII))) {
      String line;
      while ((line = is.readLine()) != null) {
        if (!line.startsWith("-")) {
          sb.append(line);
          sb.append('\n');
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
}
