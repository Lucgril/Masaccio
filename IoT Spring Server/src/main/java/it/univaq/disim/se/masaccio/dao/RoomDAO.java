package it.univaq.disim.se.masaccio.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import it.univaq.disim.se.masaccio.utility.RoomDataRepository;
import it.univaq.disim.se.masaccio.data.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.univaq.disim.se.masaccio.utility.MyCassandraTemplate;


/**
 * DAOImpl class for Employee to perform CRUD operation.
 */
@Repository
public class RoomDAO {

    @Autowired
    private RoomDataRepository dataRepository;

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;


    public Room createRoom(Room room) {
        return myCassandraTemplate.create(room);
    }

    public Room getRoom(long id) {
        return myCassandraTemplate.findById(id, Room.class);
    }

    public Room updateRoom(Room room) {
        return myCassandraTemplate.update(room, Room.class);
    }

    public void deleteRoom(long id) {
        myCassandraTemplate.deleteById(id, Room.class);
    }

    public List<Room> getAllRooms() {
        List<Room> roomsList = new ArrayList<Room>();
        for (Room room : dataRepository.findRoomsLimit()) {
            roomsList.add(room);
        }
        Collections.sort(roomsList);
        return roomsList;
    }
}

