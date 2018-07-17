package org.song.mybatis.servlet;

import org.song.mybatis.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	UserServiceImpl userService;

	@RequestMapping("/allUser")
	@ResponseBody
	public Object selectAllUser(){
		return userService.searchAllUser();
	}
	
}
