package com.fanhehe.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import com.fanhehe.api.dao.User;
import com.fanhehe.api.service.UserService;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class HomeController {

	private UserService userService;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String actionIndex() {
		return new Date().toString();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ArrayList<String> actionList() {
		ArrayList<String> list = new  ArrayList<>();

		list.add("1");
		list.add("2");
		return list;
	}

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public HashMap<String, String> actionMap(@RequestParam(name = "id", defaultValue = "200") int id) {

		HashMap<String, String> map = new HashMap<>();

		map.put("user_id", String.valueOf(id));

		return map;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User actionUser(@RequestParam(name = "id", defaultValue = "1") long id,
						   @RequestParam(name = "name", defaultValue = "default-name") String name) {

		if (userService.getUserInfoBy(id) == null) {
			userService.createUser(id, name);
			return new User();
		}

		return userService.getUserInfoBy(id);
	}
}