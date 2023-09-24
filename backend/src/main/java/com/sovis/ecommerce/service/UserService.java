package com.sovis.ecommerce.service;

import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.models.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service UserService.
 */
@Service
public class UserService {
  UserRepository userRepository;

  /**
   * Constructor.
   */
  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    Optional<User> userFound = userRepository.findByEmail(user.getEmail());
    if (userFound.isPresent()) {
      throw new RuntimeException("Email already registered");
    }
    return userRepository.save(user);
  }
}
