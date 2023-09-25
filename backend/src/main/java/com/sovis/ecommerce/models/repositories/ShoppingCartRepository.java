package com.sovis.ecommerce.models.repositories;

import com.sovis.ecommerce.models.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

  ShoppingCart findByUserId(Long userId);
}
