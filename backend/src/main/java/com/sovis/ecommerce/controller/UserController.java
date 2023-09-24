package com.sovis.ecommerce.controller;

import com.sovis.ecommerce.dto.UserRequestDto;
import com.sovis.ecommerce.exception.UserNotFoundException;
import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller User.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
  UserService service;

  /**
   * Constructor.
   */
  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  /**
   * PostMapping.
   */
  @PostMapping()
  public ResponseEntity<User> registerUser(@RequestBody UserRequestDto userRequestDto) {
    User userDto = new User(userRequestDto);
    User registeredUser = service.registerUser(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
  }

  @PostMapping("user")
  public ResponseEntity<User> getUserByEmail(@RequestBody UserRequestDto userRequestDto) {
    try {
      User userDto = new User(userRequestDto);
      User userFound = service.getUserByEmail(userDto);
      return ResponseEntity.status(HttpStatus.OK).body(userFound);
    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
