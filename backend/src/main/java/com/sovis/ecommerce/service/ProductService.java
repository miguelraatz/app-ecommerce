package com.sovis.ecommerce.service;

import com.sovis.ecommerce.models.entities.Product;
import com.sovis.ecommerce.models.entities.ShoppingCart;
import com.sovis.ecommerce.models.repositories.ProductRepository;
import com.sovis.ecommerce.models.repositories.ShoppingCartRepository;
import com.sovis.ecommerce.models.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Product.
 */
@Service
public class ProductService {
  ProductRepository productRepository;
  ShoppingCartRepository shoppingCartRepository;
  UserRepository userRepository;

  /**
   * Constructor.
   */
  @Autowired
  public ProductService(ProductRepository repository,
      ShoppingCartRepository shoppingCartRepository,
      UserRepository userRepository) {
    this.productRepository = repository;
    this.shoppingCartRepository = shoppingCartRepository;
    this.userRepository = userRepository;
  }

  /**
   * Get all products.
   */
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public ShoppingCart addProductToCart(Long userId, Long productId) {
    try {
      if (productId == null) {
        throw new IllegalArgumentException("O ID do produto não pode ser nulo.");
      }

      ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId);

      if (shoppingCart == null) {
        shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userRepository.findById(userId).orElse(null));
      }

      Product product = productRepository.findById(productId).orElse(null);
      if (product != null) {
        shoppingCart.setProductsId(product);
      } else {
        throw new IllegalArgumentException("Produto não encontrado com o ID especificado.");
      }

      return shoppingCartRepository.save(shoppingCart);
    } catch (Exception e) {
      throw new RuntimeException("Ocorreu um erro ao adicionar o produto ao carrinho.");
    }
  }

}
