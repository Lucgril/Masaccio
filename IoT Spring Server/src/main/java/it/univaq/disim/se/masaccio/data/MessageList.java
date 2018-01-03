package it.univaq.disim.se.masaccio.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("messages")
public class MessageList implements Serializable, Comparable<MessageList> {

    @PrimaryKey("id")
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="MST")
    @Column("timestamp")
    private Date timestamp;

    @Column("text")
    private String text;

    @Column("sender")
    private int idSender;


    public MessageList() {
        super();
    }

    @JsonCreator
    public MessageList(@JsonProperty("id") String id, @JsonProperty("timestamp") Date timestamp, @JsonProperty("text") String text, @JsonProperty("idSender") int idSender) {
        this.id = id;
        this.timestamp = timestamp;
        this.text = text;
        this.idSender = idSender;
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

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdSender() {
        return this.idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }
    
    @Override
	public int compareTo(MessageList messageList) {
		return messageList.timestamp.compareTo(this.timestamp);
	}
}