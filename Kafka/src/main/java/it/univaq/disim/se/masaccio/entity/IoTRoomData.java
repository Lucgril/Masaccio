package it.univaq.disim.se.masaccio.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class IoTRoomData implements Serializable{
	
	private String room;
	private int numberOfPeople;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="MST")
	private Date timestamp;
	
	public IoTRoomData(){
		
	}
	
	public IoTRoomData(String room, Date timestamp, int numberOfPeople) {
		super();
		this.room = room;
		this.numberOfPeople = numberOfPeople;
		this.timestamp = timestamp;
	}

	public String getRoom() {
		return room;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
