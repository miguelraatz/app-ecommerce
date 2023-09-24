package com.sovis.ecommerce.controller;

import com.sovis.ecommerce.dto.UserDto;
import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.service.UserService;
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
@RequestMapping("/")
public class UserController {
  UserService userService;

  /**
   * Constructor.
   */
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * PostMapping.
   */
  @PostMapping()
  public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
    User createdUser = userService.createUser(userDto.toUser());
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }
}
