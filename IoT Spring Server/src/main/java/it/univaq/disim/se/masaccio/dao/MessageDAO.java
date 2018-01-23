package it.univaq.disim.se.masaccio.dao;

import it.univaq.disim.se.masaccio.data.MessageList;
import it.univaq.disim.se.masaccio.utility.MessageDataRepository;
import it.univaq.disim.se.masaccio.utility.MyCassandraTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MessageDAO {

    @Autowired
    private MessageDataRepository messageDataRepository;

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

    public MessageList createRoom(MessageList messageList) {
        return myCassandraTemplate.create(messageList);
    }
    
    //private List<MessageList>  messagesList = new ArrayList<MessageList>();

    public List<MessageList> getAllMessages() {
    	
    	 List<MessageList> messageList = new ArrayList<MessageList>();
         for (MessageList message : messageDataRepository.findAll()) {
        	 messageList.add(message);
         }
         Collections.sort(messageList);
         return messageList;
    }
}
