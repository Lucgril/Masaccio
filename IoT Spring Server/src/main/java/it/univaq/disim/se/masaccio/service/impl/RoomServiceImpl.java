package it.univaq.disim.se.masaccio.service.impl;

import it.univaq.disim.se.masaccio.dao.model.RoomDAO;
import it.univaq.disim.se.masaccio.data.impl.RoomImpl;
import it.univaq.disim.se.masaccio.service.model.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Service Impl class for Room to perform CRUD operation.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDAO roomDAO;

    /**
     * Default Constructor
     */
    public RoomServiceImpl() {
        super();
    }

    @Override
    public RoomImpl createRoom(RoomImpl room) {
        return roomDAO.createRoom(room);
    }

    @Override
    public RoomImpl getRoom(long id) {
        return roomDAO.getRoom(id);
    }

    @Override
    public RoomImpl updateRoom(RoomImpl room) {
        return roomDAO.updateRoom(room);
    }

    @Override
    public void deleteRoom(long id) {
        roomDAO.deleteRoom(id);
    }

    @Override
    public List<RoomImpl> getAllRooms() {
        return roomDAO.getAllRooms();
    }
}
