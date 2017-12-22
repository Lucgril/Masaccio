package it.univaq.disim.se.masaccio.controller;

import it.univaq.disim.se.masaccio.data.impl.RoomImpl;
import it.univaq.disim.se.masaccio.service.model.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;


@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    RoomImpl create(@RequestBody RoomImpl room) {
        return roomService.createRoom(room);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") long id) {
        roomService.deleteRoom(id);
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    List<RoomImpl> findAll() {
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    RoomImpl findById(@PathVariable("id") long id) {
        return roomService.getRoom(id);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.PUT)
    RoomImpl update(@RequestBody RoomImpl room) {
        return roomService.updateRoom(room);
    }
}
