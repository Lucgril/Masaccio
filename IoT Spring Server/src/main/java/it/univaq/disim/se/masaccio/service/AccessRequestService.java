package it.univaq.disim.se.masaccio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.se.masaccio.dao.AccessRequestDao;
import it.univaq.disim.se.masaccio.data.AccessRequest;

@Service
public class AccessRequestService {
	@Autowired
    private AccessRequestDao accessRequestDao;
    
    public List<AccessRequest> getAllAccessRequests() {
        return accessRequestDao.getAllAccessRequests();
    }
}
