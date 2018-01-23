package it.univaq.disim.se.masaccio.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AccessRequest implements Serializable{
	
	private String item;
	private String cardUid;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone="MST")
	private Date timestamp;
	
	public AccessRequest(){
		
	}
	
	public AccessRequest(String item, String cardUid, Date timestamp) {
		super();
		this.item = item;
		this.cardUid = cardUid;
		this.timestamp = timestamp;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCardUid() {
		return cardUid;
	}

	public void setCardUid(String cardUid) {
		this.cardUid = cardUid;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
