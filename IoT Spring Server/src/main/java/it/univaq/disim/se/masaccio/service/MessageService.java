package it.univaq.disim.se.masaccio.service;

import it.univaq.disim.se.masaccio.dao.MessageDAO;
import it.univaq.disim.se.masaccio.data.MessageList;
import it.univaq.disim.se.masaccio.data.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDAO messageDAO;

    public MessageList createMessageList(MessageList messageList) {
        return messageDAO.createRoom(messageList);
    }
    
    public List<MessageList> getAllMessages() {
        return messageDAO.getAllMessages();
    }
}
