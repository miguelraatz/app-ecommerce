package com.sovis.ecommerce.controller;

import com.sovis.ecommerce.models.entities.Product;
import com.sovis.ecommerce.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Product.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

  ProductService service;

  /**
   * Constructor.
   */
  @Autowired
  public ProductController(ProductService service) {
    this.service = service;
  }

  @GetMapping("home")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = service.getAllProducts();
    return ResponseEntity.status(HttpStatus.OK).body(products);
  }

}
