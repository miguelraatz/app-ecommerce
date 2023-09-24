package com.sovis.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(
    Long id,
    @NotBlank
    String name,
    @NotBlank
    String email,
    @NotBlank
    String password
) {
}
