package it.univaq.disim.se.masaccio.service;

import it.univaq.disim.se.masaccio.data.User;

public interface UserService {

    User findById(int id);

    User findBySso(String sso);
    
}
