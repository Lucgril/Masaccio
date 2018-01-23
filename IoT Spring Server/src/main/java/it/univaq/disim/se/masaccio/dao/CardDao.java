package it.univaq.disim.se.masaccio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.univaq.disim.se.masaccio.data.Card;
import it.univaq.disim.se.masaccio.utility.CardRepository;

@Repository
public class CardDao {
	
	@Autowired
	private CardRepository cardRepository;
	
	public Card findByUid(String uid) {
		return cardRepository.findByUid(uid);
	}
}
