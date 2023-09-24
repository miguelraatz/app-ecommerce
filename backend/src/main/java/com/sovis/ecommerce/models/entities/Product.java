package com.sovis.ecommerce.models.entities;

import jakarta.persistence.*;

/**
 * Entity Product.
 */
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private Double price;

  @Column(name = "image")
  private String image;

  /**
   * Constructor.
   */
  public Product() {}

  public Product(String name, String description, Double price, String image) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.image = image;
  }
}
