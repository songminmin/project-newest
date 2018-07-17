package org.song.redis.service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.song.common.redis.entity.RUser;
import org.song.common.redis.service.UserService;
import org.song.redis.RedisKeyPrefix;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;

@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService{
	
	@Resource
	RedisTemplate redisTemplate;
	
	@Resource
	StringRedisTemplate stringRedisTemplate;
	
	@SuppressWarnings("unchecked")
	@Override	
	public void addUser(){
		RUser user = new RUser();
		user.setId(1L);
		user.setName("张三");
		redisTemplate.opsForValue().set(RedisKeyPrefix.USER + 1L, user, 3000, TimeUnit.MILLISECONDS);
		RUser u1 = (RUser) redisTemplate.opsForValue().get(RedisKeyPrefix.USER + 1L);
		System.out.println(u1 != null ? u1.getName(): "");
		System.out.println("======");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		RUser u2 = (RUser) redisTemplate.opsForValue().get(RedisKeyPrefix.USER + 1L);
		System.out.println(u2 != null ? u2.getName(): "");
	}
	
	
	public void testSet(){
		RUser user1 = new RUser();
		user1.setId(1L);
		user1.setName("张三");
		stringRedisTemplate.opsForSet().add("user", String.valueOf(JSONObject.toJSON(user1)));
		RUser user2 = new RUser();
		user2.setId(2L);
		user2.setName("李四");
		stringRedisTemplate.opsForSet().add("user", String.valueOf(JSONObject.toJSON(user2)));
		stringRedisTemplate.expire("user", 10, TimeUnit.SECONDS);
		
		Set<String> set = stringRedisTemplate.opsForSet().members("user");
		System.out.println(set);
	}


	public void testString() {
		RUser user1 = new RUser();
		user1.setId(1L);
		user1.setName("张三");
		stringRedisTemplate.opsForValue().set("user1", String.valueOf(JSONObject.toJSON(user1)), 10, TimeUnit.SECONDS);
		RUser user2 = new RUser();
		user2.setId(2L);
		user2.setName("李四");
		stringRedisTemplate.opsForValue().set("user2", String.valueOf(JSONObject.toJSON(user2)), 10, TimeUnit.SECONDS);
		
		System.out.println(stringRedisTemplate.opsForValue().get("user1"));
		System.out.println(stringRedisTemplate.opsForValue().get("user2"));
		
		user1 = new RUser();
		user1.setId(1L);
		user1.setName("张三2");
		stringRedisTemplate.opsForValue().set("user1", String.valueOf(JSONObject.toJSON(user1)), 10, TimeUnit.SECONDS);
		
		System.out.println(stringRedisTemplate.opsForValue().get("user1"));
		System.out.println(stringRedisTemplate.opsForValue().get("user2"));
	}

}
