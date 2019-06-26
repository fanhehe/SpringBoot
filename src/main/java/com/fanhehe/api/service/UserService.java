package com.fanhehe.api.service;

import com.fanhehe.api.dao.User;

public interface UserService {
	User getUserInfoBy(long id);
	User createUser(long id, String name);
}