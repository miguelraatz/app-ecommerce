package com.sovis.ecommerce.dto;

import com.sovis.ecommerce.models.entities.User;

public record UserResponseDto(Long id, String name, String email, String password) {

  public UserResponseDto(User user){
    this(user.getId(), user.getName(), user.getEmail(), user.getPassword());
  }

}
