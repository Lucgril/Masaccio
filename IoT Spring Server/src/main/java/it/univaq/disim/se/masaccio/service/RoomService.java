package it.univaq.disim.se.masaccio.service;

import it.univaq.disim.se.masaccio.data.Room;
import it.univaq.disim.se.masaccio.dao.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Session Impl class for Room to perform CRUD operation.
 */
@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    /**
     * Default Constructor
     */
    public RoomService() {
        super();
    }

    public Room createRoom(Room room) {
        return roomDAO.createRoom(room);
    }

    public Room getRoom(long id) {
        return roomDAO.getRoom(id);
    }

    public Room updateRoom(Room room) {
        return roomDAO.updateRoom(room);
    }

    public void deleteRoom(long id) {
        roomDAO.deleteRoom(id);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }
}
