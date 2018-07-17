package org.song.mongo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.song.common.mongo.service.UserService;
import org.song.mongo.repository.MongoTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MongoTemplateRepository mongoTemplateRepository;
	
	@Test
	public void testSelectAllUser() throws Exception{
		System.out.println(userService.searchAllUser());
	}

	@Test
	public void update() throws Exception {
		mongoTemplateRepository.testupdate();
	}
}
