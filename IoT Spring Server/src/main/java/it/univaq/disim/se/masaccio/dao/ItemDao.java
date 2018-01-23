package it.univaq.disim.se.masaccio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.univaq.disim.se.masaccio.data.Card;
import it.univaq.disim.se.masaccio.data.Item;
import it.univaq.disim.se.masaccio.utility.CardRepository;
import it.univaq.disim.se.masaccio.utility.ItemRepository;

@Repository
public class ItemDao {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item findByName(String name) {
		return itemRepository.findByName(name);
	}
}
