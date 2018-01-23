package it.univaq.disim.se.masaccio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.se.masaccio.dao.CardDao;
import it.univaq.disim.se.masaccio.data.Card;

@Service
public class CardService {
	
	@Autowired
	private CardDao cardDao;
	
	public Card getCardByUid(String uid) {
		return cardDao.findByUid(uid);
	}

}
