package com.sovis.ecommerce.controller;

import com.sovis.ecommerce.models.entities.ShoppingCart;
import com.sovis.ecommerce.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CartController
 */
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

  CartService cartService;

  @Autowired
  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping()
  public ResponseEntity<List<ShoppingCart>> getAllCarts() {
    return ResponseEntity.status(HttpStatus.OK).body(cartService.getAllCarts());
  }

  @DeleteMapping("/{userId}/{productId}")
  public ResponseEntity deleteItem(@PathVariable Long userId, @PathVariable Long productId) {
    cartService.deleteItem(userId, productId);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
