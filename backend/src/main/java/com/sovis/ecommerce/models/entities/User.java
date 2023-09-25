package com.sovis.ecommerce.models.entities;

import com.sovis.ecommerce.dto.UserRequestDto;
import jakarta.persistence.*;
import java.util.Set;


/**
 * Entity User.
 */
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "user")
  private Set<ShoppingCart> shoppingCarts;

  public User() {}

  /**
   * Constructor.
   */
  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User(UserRequestDto user) {
    this.name = user.name();
    this.email = user.email();
    this.password = user.password();
  }

  /**
   * Getters and setters.
   */

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
