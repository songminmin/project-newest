package org.song.common.redis.entity;

import java.io.Serializable;

public class RUser implements Serializable{

	private static final long serialVersionUID = 6267627661637739113L;

	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
