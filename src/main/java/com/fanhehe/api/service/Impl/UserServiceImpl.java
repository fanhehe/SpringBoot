package com.fanhehe.api.service.Impl;

import java.util.HashMap;
import com.fanhehe.api.dao.User;
import com.fanhehe.api.service.UserService;
// import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

	private User user;

	UserServiceImpl(@Autowired User user) {
		this.user = user;
	}

	private static HashMap<Long, User> map = new HashMap<>();

	@Override
	public User getUserInfoBy(long id) {
		return map.get(id);
	}

	@Override
	public User createUser(long id, String name) {

		if (map.get(id) != null) {
			return user;
		}

		user.setId(id);
		user.setUserName(name);

		map.put(id, user);

		return user;
	}
}