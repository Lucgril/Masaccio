package it.univaq.disim.se.masaccio.controller;

import it.univaq.disim.se.masaccio.data.User;

import java.util.Date;

public class MessageResponse {

    private String id;

    private Date timestamp;

    private String text;

    private User sender;

    public MessageResponse() {
        super();
    }

    public MessageResponse(String id, Date timestamp, String text, User sender) {
        this.id = id;
        this.timestamp = timestamp;
        this.text = text;
        this.sender = sender;
    }

    public MessageResponse(String id, Date timestamp, String text) {
        this.id = id;
        this.timestamp = timestamp;
        this.text = text;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setDate(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return this.sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
