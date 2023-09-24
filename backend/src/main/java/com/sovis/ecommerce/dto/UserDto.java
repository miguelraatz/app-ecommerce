package com.sovis.ecommerce.dto;

import com.sovis.ecommerce.models.entities.User;

public record UserDto(Long id, String name, String email, String password) {

  public User toUser() {
    return new User(id, name, email, password);
  }
}
