package it.univaq.disim.se.masaccio.service;

import it.univaq.disim.se.masaccio.data.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findByToken(String token);

}
