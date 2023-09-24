package com.sovis.ecommerce.service;

import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.models.repositories.UserRepository;
import java.util.Optional;
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
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  /**
   * Method.
   */
  public User registerUser(User user) {
    Optional<User> userFound = Optional.ofNullable(repository.findByEmail(user.getEmail()));
    if (userFound.isPresent()) {
      throw new RuntimeException("User already exists");
    } else {
      return repository.save(user);
    }
  }

  public User getUserByEmail(User user) {
    Optional<User> userFound = Optional.ofNullable(repository.findByEmail(user.getEmail()));
    if (userFound.isPresent()) {
      return userFound.get();
    } else {
      throw new RuntimeException("User not found");
    }
  }
}
