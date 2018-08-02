package com.dbs.askleader.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReviewComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	
	@ManyToOne
	@JoinColumn(name="leader_id")
	private Leader leaderId;
	
	@Column(nullable= false)
	private String comment;
	
	@Column(nullable=false)
	private long timestamp;
	
	@Column
	private String browserId;
	
	
	public ReviewComment() {
		this.timestamp = new Date().getTime();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public Leader getLeaderId() {
		return leaderId;
	}


	public void setLeaderId(Leader leaderId) {
		this.leaderId = leaderId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	public String getBrowserId() {
		return browserId;
	}


	public void setBrowserId(String browserId) {
		this.browserId = browserId;
	}
	
	

}
