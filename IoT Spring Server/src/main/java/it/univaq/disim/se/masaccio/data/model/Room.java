package it.univaq.disim.se.masaccio.data.model;


import java.util.Date;

public interface Room {

    String getRoom();

    int getNumberOfPeople();

    Date getTimestamp();

    void setRoom(String room);

    void setNumberOfPeople(int numberOfPeople);

    void setTimestamp(Date timestamp);

}
