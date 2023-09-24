package com.sovis.ecommerce.database;

import com.sovis.ecommerce.models.entities.User;
import com.sovis.ecommerce.models.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
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
  public LoadUsers(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostConstruct
  public void fillUserTable() {
    User userTeste = new User("teste", "teste@teste.com", "123456");
    userRepository.save(userTeste);
  }
}
