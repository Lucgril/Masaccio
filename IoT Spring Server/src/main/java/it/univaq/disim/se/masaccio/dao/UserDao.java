package it.univaq.disim.se.masaccio.dao;

import it.univaq.disim.se.masaccio.data.User;

public interface UserDao {

    User findById(int id);

    User findBySSO(String sso);
    
}
