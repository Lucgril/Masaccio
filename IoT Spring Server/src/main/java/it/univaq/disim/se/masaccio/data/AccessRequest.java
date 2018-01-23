package it.univaq.disim.se.masaccio.data;

import java.util.Date;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("AccessRequest")
public class AccessRequest implements Comparable<AccessRequest> {

    @PrimaryKey("item")
    private String item;

    @Column("cardUid")
    private String cardUid;

    @Column("timestamp")
    private Date timestamp;
    
    /**
     * Default constructor
     */
    public AccessRequest() {
        super();
    }

    /**
     * Parameterized Constructor
     * @param item
     * @param cardUid
     * @param timestamp
     */
    public AccessRequest(String item, String cardUid, Date timestamp){
        this.item= item;
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

	@Override
	public int compareTo(AccessRequest o) {
		o.timestamp.before(this.timestamp);
		return 0;
	}
    
}
