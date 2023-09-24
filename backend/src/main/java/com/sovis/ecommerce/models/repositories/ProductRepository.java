package com.sovis.ecommerce.models.repositories;

import com.sovis.ecommerce.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
