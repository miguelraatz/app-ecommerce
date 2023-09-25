package com.sovis.ecommerce.service;

import com.sovis.ecommerce.models.entities.Product;
import com.sovis.ecommerce.models.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Product.
 */
@Service
public class ProductService {
  ProductRepository repository;

  /**
   * Constructor.
   */
  @Autowired
  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  /**
   * Get all products.
   */
  public List<Product> getAllProducts() {
    return repository.findAll();
  }
}
