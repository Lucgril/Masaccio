package it.univaq.disim.se.masaccio.controller;

import it.univaq.disim.se.masaccio.data.Message;
import it.univaq.disim.se.masaccio.data.Session;
import it.univaq.disim.se.masaccio.service.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private SessionRepository sessionRepository;

    @CrossOrigin(origins = { "http://localhost:63342" }, maxAge = 6000)
    @PostMapping("/message/{token}")
    public void insertMessage(@RequestBody Message m, @PathVariable String token) {
        Session session = sessionRepository.findByToken(token);
        System.out.println(session.getUser().getId());
        System.out.println(token);
        System.out.println(m.getText());
        System.out.println(m.getTopic());
    }
}
