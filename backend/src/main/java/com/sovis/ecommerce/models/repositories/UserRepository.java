package com.sovis.ecommerce.models.repositories;

import com.sovis.ecommerce.models.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository UserRepository.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
