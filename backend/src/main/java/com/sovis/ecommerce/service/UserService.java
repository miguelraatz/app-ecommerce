package com.sovis.ecommerce.service;

import com.sovis.ecommerce.exception.UserNotFoundException;
import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.models.repositories.UserRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service User.
 */
@Service
public class UserService {

  UserRepository repository;

  /**
   * Constructor.
   */
  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  /**
   * Method.
   */
  public User registerUser(User user) {
    Optional<User> userFound = Optional.ofNullable(repository.findByEmail(user.getEmail()));
    if (userFound.isPresent()) {
      throw new RuntimeException("Usuário já cadastrado!");
    } else {
      return repository.save(user);
    }
  }

  public User getUserByEmail(User user) {
    Optional<User> userFound = Optional.ofNullable(repository.findByEmail(user.getEmail()));
    if (userFound.isPresent()) {
      return userFound.get();
    } else {
      throw new UserNotFoundException();
    }
  }
}
