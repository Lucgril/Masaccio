package it.univaq.disim.se.masaccio.utility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.univaq.disim.se.masaccio.data.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item findByName(String name);
}
