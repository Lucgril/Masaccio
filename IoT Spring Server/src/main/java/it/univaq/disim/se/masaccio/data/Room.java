package it.univaq.disim.se.masaccio.data;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;


@Table("NumberOfPeople")
public class Room implements Comparable<Room> {

    @PrimaryKey("room")
    private String room;

    @Column("numberofpeople")
    private int numberOfPeople;

    @Column("timestamp")
    private Date timestamp;

    /**
     * Default constructor
     */
    public Room() {
        super();
    }

    /**
     * Parameterized Constructor
     * @param room
     * @param numberOfPeople
     * @param timestamp
     */
    public Room(String room, int numberOfPeople, Date timestamp){
        this.room= room;
        this.numberOfPeople = numberOfPeople;
        this.timestamp = timestamp;
    }


    public String getRoom() {
        return this.room;
    }

    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

	@Override
	public int compareTo(Room room) {
		return Integer.parseInt(this.room) - Integer.parseInt(room.room);
	}
}

