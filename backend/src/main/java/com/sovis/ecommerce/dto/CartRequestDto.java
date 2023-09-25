package com.sovis.ecommerce.dto;

public record CartRequestDto(
  Long userId,
  Long productId
) {

}
