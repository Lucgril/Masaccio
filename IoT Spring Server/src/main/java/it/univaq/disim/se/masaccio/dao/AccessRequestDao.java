package it.univaq.disim.se.masaccio.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.univaq.disim.se.masaccio.data.AccessRequest;
import it.univaq.disim.se.masaccio.data.MessageList;
import it.univaq.disim.se.masaccio.utility.AccessRequestDataRepository;
import it.univaq.disim.se.masaccio.utility.MessageDataRepository;
import it.univaq.disim.se.masaccio.utility.MyCassandraTemplate;

@Repository
public class AccessRequestDao {
	@Autowired
    private AccessRequestDataRepository accessRequestDataRepository;

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;
    
    //private List<MessageList>  messagesList = new ArrayList<MessageList>();

    public List<AccessRequest> getAllAccessRequests() {
    	
    	 List<AccessRequest> AccessRequestList = new ArrayList<AccessRequest>();
         for (AccessRequest accessRequest : accessRequestDataRepository.findAccessRequestsLimit()) {
        	 AccessRequestList.add(accessRequest);
         }
         Collections.sort(AccessRequestList);
         return AccessRequestList;
    }
}
