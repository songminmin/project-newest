package org.song.mongo.service;

import java.util.List;

import org.song.common.mongo.entity.MUser;
import org.song.common.mongo.service.UserService;
import org.song.mongo.repository.MongoTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private MongoTemplateRepository mongoTemplateRepository;

	@Override
	public List<MUser> searchAllUser() {
		return mongoTemplateRepository.searchAllUser();
	}

}
