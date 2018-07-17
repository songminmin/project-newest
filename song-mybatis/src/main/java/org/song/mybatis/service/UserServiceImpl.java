package org.song.mybatis.service;

import java.util.List;

import org.song.common.mysql.entity.User;
import org.song.common.mysql.service.UserService;
import org.song.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;

@Service
@org.springframework.stereotype.Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> searchAllUser(){
		return userMapper.selectAll();
	}

}
