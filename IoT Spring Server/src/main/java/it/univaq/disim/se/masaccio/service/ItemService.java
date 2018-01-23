package it.univaq.disim.se.masaccio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.se.masaccio.dao.ItemDao;
import it.univaq.disim.se.masaccio.data.Item;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	public Item getItemByName(String name) {
		return itemDao.findByName(name);
	}

}

