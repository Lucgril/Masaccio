package it.univaq.disim.se.masaccio.data.impl;

import it.univaq.disim.se.masaccio.data.model.Room;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;


@Table("NumberOfPeople")
public class RoomImpl implements Room {

    @PrimaryKey("room")
    private String room;

    @Column("numberofpeople")
    private int numberOfPeople;

    @Column("timestamp")
    private Date timestamp;
    
    /**
     * Default constructor
     */
    public RoomImpl() {
    		super();
    }
    
    /**
     * Parameterized Constructor
     * @param room
     * @param numberOfPeople
     * @param timestamp
     */
    public RoomImpl(String room, int numberOfPeople, Date timestamp){
        this.room= room;
        this.numberOfPeople = numberOfPeople;
        this.timestamp = timestamp;
    }
    
    /**
     * @return the room
     */
    @Override
    public String getRoom() {
        return this.room;
    }

    /**
     * @return the numberOfPeople
     */
    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    /**
     * @return the timestamp
     */
    @Override
    public Date getTimestamp() {
        return this.timestamp;
    }

    /**
     * @param room the room to set
     */
    @Override
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @param numberOfPeople the roomNumber to set
     */
    @Override
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    /**
     * @param timestamp the timestamp to set
     */
    @Override
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
