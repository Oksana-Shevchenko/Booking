package com.epam.service;

import java.util.List;

import com.epam.model.User;

public interface UserService {
	User getUserById();
	User getUserByEmail(String email);
	List<User> getUsersByName(String name, int pageSize, int pageNum);
	User createUser(User user);
	User updateUser(User user);
	boolean deleteUser(long userId);
}
