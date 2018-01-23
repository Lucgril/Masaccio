package it.univaq.disim.se.masaccio.controller;

import it.univaq.disim.se.masaccio.data.AccessRequest;
import it.univaq.disim.se.masaccio.data.AccessResponse;
import it.univaq.disim.se.masaccio.data.Card;
import it.univaq.disim.se.masaccio.data.Item;
import it.univaq.disim.se.masaccio.data.User;
import it.univaq.disim.se.masaccio.data.UserProfile;
import it.univaq.disim.se.masaccio.service.AccessRequestService;
import it.univaq.disim.se.masaccio.service.CardService;
import it.univaq.disim.se.masaccio.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/accessControl")
public class AccessControlController {
    @Autowired
    private AccessRequestService accessRequestService;
    
    @Autowired
    private CardService cardService;
    
    @Autowired
    private ItemService itemSerivce;
    
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<AccessResponse> AccessResponses() {
        List<AccessRequest> AccessRequestList = accessRequestService.getAllAccessRequests();
        List<AccessResponse> accessResponseList = new ArrayList<AccessResponse>();
        
        for (AccessRequest request : AccessRequestList) {
        	User user = getUserByCard(request.getCardUid());
        	boolean hasAccess = hasAccess(user, request.getItem());
        	
        	AccessResponse accessResponse = new AccessResponse();
        	accessResponse.setUser(user.getFirstName() + " " + user.getLastName());
        	accessResponse.setItem(request.getItem());
        	String timestamp = df.format(request.getTimestamp());
        	accessResponse.setTimestamp(timestamp);
        	accessResponse.setAllowed(hasAccess);
        	
        	accessResponseList.add(accessResponse);
        }
        
        return accessResponseList;
    }
    
    private User getUserByCard(String uid) {
    	Card card = cardService.getCardByUid(uid);
    	return card.getUser();
    	//return card.getUser();
    }
    
    private boolean hasAccess(User user, String itemName){
    	Item item = itemSerivce.getItemByName(itemName);
    	Set<UserProfile> userProfiles = user.getUserProfiles();
    	
    	boolean hasAccess = false;
    	
    	for(UserProfile userProfile : item.getUserProfiles()) {
    		if(userProfiles.contains(userProfile)) {
    			hasAccess = true;
    			break;
    		}
    	}
    	
    	return hasAccess;
    }
}
