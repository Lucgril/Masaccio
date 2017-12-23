package it.univaq.disim.se.masaccio.service;

import it.univaq.disim.se.masaccio.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
