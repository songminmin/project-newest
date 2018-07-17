package org.song.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.song.common.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testSelectAllUser() throws Exception{
		userService.addUser();
	}
	

}
