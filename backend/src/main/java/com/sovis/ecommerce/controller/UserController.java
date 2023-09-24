package com.sovis.ecommerce.controller;

import com.sovis.ecommerce.dto.UserRequestDto;
import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.models.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller User.
 */
@RestController
@RequestMapping("/user")
public class UserController {
  UserRepository repository;

  /**
   * Constructor.
   */
  @Autowired
  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  /**
   * PostMapping.
   */
  @PostMapping()
  public ResponseEntity<User> registerUser(@RequestBody UserRequestDto userRequestDto) {
    Optional<User> userFound = Optional.ofNullable(repository.findByEmail(userRequestDto.email()));
    if (userFound.isPresent()) {
      throw new RuntimeException("User already exists");
    }
    User newUser = new User(userRequestDto);
    repository.save(newUser);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
