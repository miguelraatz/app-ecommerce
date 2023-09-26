package com.sovis.ecommerce.models.entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity Cart.
 */
@Entity
@Table(name = "cart")
public class ShoppingCart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToMany
  @JoinTable(
      name = "shopping_cart_product",
      joinColumns = @JoinColumn(name = "cart_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<Product> products = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(Product id) {
    this.products.add(id);
  }

  public void setUser(User user) {
    this.user = user;
  }
}
