package com.fanhehe.api.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;


@RestController
public class HomeController {

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
}