package com.sovis.ecommerce.database;

import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.models.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * LoadUsers
 */
@Component
public class LoadUsers {
  UserRepository userRepository;

  /**
   * Constructor.
   */
  @Autowired
  public LoadUsers(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostConstruct
  public void fillUserTable() {
    Optional<User> user = Optional.ofNullable(userRepository.findByEmail("teste@teste.com"));
    if (user.isPresent()) {
      return;
    }
    User userTeste = new User("teste", "teste@teste.com", "123456");
    userRepository.save(userTeste);
  }
}
