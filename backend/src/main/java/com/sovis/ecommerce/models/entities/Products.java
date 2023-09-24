package com.sovis.ecommerce.models.entities;

import jakarta.persistence.*;

/**
 * Entity Products.
 */
@Entity
@Table(name = "products")
public class Products {

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
  public Products() {}

  public Products(String name, String description, Double price, String image) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.image = image;
  }
}
