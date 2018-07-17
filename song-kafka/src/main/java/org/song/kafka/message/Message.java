package org.song.kafka.message;

import java.util.Date;

public class Message {
	
	private Long id;
	
	private String uuid;
	
	private Date sendTime;
	
	public Message(Long id, String uuid, Date sendTime) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.sendTime = sendTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
