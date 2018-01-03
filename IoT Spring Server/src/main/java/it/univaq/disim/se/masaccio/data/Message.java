package it.univaq.disim.se.masaccio.data;


import java.util.Date;

public class Message {

    private String text;
    private String topic;
    private Date timestamp;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getTimestamp() { return this.timestamp;}

    public void setTimestamp(Date timestamp) { this.timestamp = timestamp;}
}
