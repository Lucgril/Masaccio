package it.univaq.disim.se.masaccio.controller;

import it.univaq.disim.se.masaccio.service.RoomService;
import it.univaq.disim.se.masaccio.data.Room;
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
    Room create(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") long id) {
        roomService.deleteRoom(id);
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    List<Room> findAll() {
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    Room findById(@PathVariable("id") long id) {
        return roomService.getRoom(id);
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.PUT)
    Room update(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }
}
