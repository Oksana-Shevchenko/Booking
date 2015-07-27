package com.epam.dao;

import java.util.List;

import com.epam.model.User;

public interface UserDao {
	boolean delete(long userId);
	User getUserByEmail(String email);
	User updateUser(User user);
	User createUser(User user);
	List<User> getUsersByName(String name, int pageSize, int pageNum);
}
