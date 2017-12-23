package it.univaq.disim.se.masaccio.controller;

import it.univaq.disim.se.masaccio.data.Session;
import it.univaq.disim.se.masaccio.data.User;
import it.univaq.disim.se.masaccio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = { "http://localhost:63342" }, maxAge = 6000)
    @PostMapping("/login")
    public Response login(@RequestBody User u) {
        Session session = userService.login(u.getUsername(), u.getPassword());
        if (session != null) {
            Response<Login> result = new Response<>(true, Response.DEFAULT_RESPONSE_OK.getMessage());
            Login login = new Login();
            login.setToken(session.getToken());
            login.setUsername(session.getUser().getUsername());
            login.setName(session.getUser().getName());
            login.setSurname(session.getUser().getSurname());
            login.setEmail(session.getUser().getEmail());
            result.setData(login);
            return result;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @CrossOrigin(origins = { "http://localhost:63342" }, maxAge = 6000)
    @PostMapping("/logout/{token}")
    public Response logout(@PathVariable String token) {
        userService.logout(token);
        return Response.DEFAULT_RESPONSE_OK;
    }
}
