package it.univaq.disim.se.masaccio.utility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.univaq.disim.se.masaccio.data.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
	
	Card findByUid(String uid);
}
