package org.song.common.mongo.service;

import java.util.List;

import org.song.common.mongo.entity.MUser;

public interface UserService {
	
	public List<MUser> searchAllUser();

}
