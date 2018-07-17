package org.song.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserServiceImpl redisService;
	
	@Test
	public void addUser() throws InterruptedException{
		redisService.addUser();
	}

	
	@Test
	public void testSet() throws InterruptedException{
		redisService.testSet();
	}
	
	@Test
	public void testString() {
		redisService.testString();
	}
}
