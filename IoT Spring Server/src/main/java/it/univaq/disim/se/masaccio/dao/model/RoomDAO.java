package it.univaq.disim.se.masaccio.dao.model;

import it.univaq.disim.se.masaccio.data.impl.RoomImpl;
import java.util.List;


/**
 * DAO interface for Room to perform CRUD operation.
 */
public interface RoomDAO {
    /**
     * Used to Create the Employee Information
     * @param room
     * @return {@link RoomImpl}
     */
    public RoomImpl createRoom(RoomImpl room);

    /**
     * Getting the Room Information using Id
     * @param id
     * @return {@link RoomImpl}
     */
    public RoomImpl getRoom(long id);

    /**
     * Used to Update the Room Information
     * @param room
     * @return {@link RoomImpl}
     */

    public RoomImpl updateRoom(RoomImpl room);

    /**
     * Deleting the Room Information using Id
     * @param id
     */
    public void deleteRoom(long id);

    /**
     * Getting the All Rooms information
     * @return
     */
    public List<RoomImpl> getAllRooms();
}
