package com.sovis.ecommerce.dto;

public record UserRequestDto(
    Long id,
    String name,
    String email,
    String password
) {
}
