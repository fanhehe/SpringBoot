package com.fanhehe.api.service.Impl;

import java.util.HashMap;
import javax.annotation.Resource;
import com.fanhehe.common.model.User;
import com.fanhehe.common.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Reference;


@Service(version="1.0.0")
public class UserServiceImpl implements UserService {

	private static HashMap<Long, User> map = new HashMap<>();

	@Override
	public User getUserInfoBy(long id) {
		return map.get(id);
	}

	@Override
	public User createUser(long id, String name) {

		if (map.get(id) != null) {
			return map.get(id);
		}

		User user = new User();

		user.setId(id);
		user.setUserName(name);

		map.put(id, user);

		return user;
	}
}