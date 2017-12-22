package it.univaq.disim.se.masaccio.dao.impl;

import java.util.ArrayList;
import java.util.List;
import it.univaq.disim.se.masaccio.dao.model.RoomDAO;
import it.univaq.disim.se.masaccio.utility.RoomDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.univaq.disim.se.masaccio.data.impl.RoomImpl;
import it.univaq.disim.se.masaccio.utility.MyCassandraTemplate;


/**
 * DAOImpl class for Employee to perform CRUD operation.
 */
@Repository
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private RoomDataRepository dataRepository;

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

    private List<RoomImpl> roomsList = new ArrayList<RoomImpl>();

    @Override
    public RoomImpl createRoom(RoomImpl room) {
        return myCassandraTemplate.create(room);
    }

    @Override
    public RoomImpl getRoom(long id) {
        return myCassandraTemplate.findById(id, RoomImpl.class);
    }

    @Override
    public RoomImpl updateRoom(RoomImpl room) {
        return myCassandraTemplate.update(room, RoomImpl.class);
    }

    @Override
    public void deleteRoom(long id) {
        myCassandraTemplate.deleteById(id, RoomImpl.class);
    }

    @Override
    public List<RoomImpl> getAllRooms() {
        for (RoomImpl room : dataRepository.findRoomsLimit()) {
            roomsList.add(room);
        }
        return roomsList;
    }
}
