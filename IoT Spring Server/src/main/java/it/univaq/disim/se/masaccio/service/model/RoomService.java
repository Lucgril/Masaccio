package it.univaq.disim.se.masaccio.service.model;

import java.util.List;
import it.univaq.disim.se.masaccio.data.impl.RoomImpl;


/**
 * Service interface for Room to perform CRUD operation.
 */
public interface RoomService {
    /**
     * Used to Create the Room Information
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
