package com.sovis.ecommerce.service;

import com.sovis.ecommerce.models.entities.Product;
import com.sovis.ecommerce.models.entities.ShoppingCart;
import com.sovis.ecommerce.models.repositories.ShoppingCartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * CartService.
 */
@Service
public class CartService {

  ShoppingCartRepository repository;

  /**
   * Constructor.
   */
  @Autowired
  public CartService(ShoppingCartRepository repository) {
    this.repository = repository;
  }

  /**
   * getAllCarts.
   */
  public List<ShoppingCart> getAllCarts() {
    return repository.findAll();
  }

  /**
   * Delete item from cart.
   */
  public void deleteItem(Long userId, Long productId) {
    ShoppingCart cart = repository.findByUserId(userId);

    if (cart != null) {
      List<Product> productsInCart = cart.getProducts();

      Product productToRemove = null;
      for (Product product : productsInCart) {
        if (product.getId().equals(productId)) {
          productToRemove = product;
          break;
        }
      }

      if (productToRemove != null) {
        productsInCart.remove(productToRemove);
      }

      repository.save(cart);
    } else {
      throw new RuntimeException("Cart not found");
    }
  }

}
