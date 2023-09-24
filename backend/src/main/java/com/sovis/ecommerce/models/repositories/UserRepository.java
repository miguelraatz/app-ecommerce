package com.sovis.ecommerce.models.repositories;

import com.sovis.ecommerce.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository UserRepository.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);
}
