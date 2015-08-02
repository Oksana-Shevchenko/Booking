package com.epam.service;

import java.util.List;

import com.epam.dao.UserDao;
import com.epam.model.User;
import com.epam.repository.RepositoryBooking;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private RepositoryBooking repositoryBooking;
	
	public void setRepositoryBooking(RepositoryBooking repository){
		repositoryBooking = repository;
	}
	
	public RepositoryBooking getRepositoryBooking(){
		return repositoryBooking;
	}
	
	public void setUserDao(UserDao user) {
		userDao = user;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	
	//TODO:Not implemented
	public User getUserById() {
		return null;
	}
	
	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		List<User> lst = getUserDao().getUsersByName(name, pageSize, pageNum);
		return lst;
	}

	public User getUserByEmail(String email) {
		User user = getUserDao().getUserByEmail(email);
		return user;
	}

	public User createUser(User user) {
		if (getUserDao().getUserByEmail(user.getEmail()) != null) {
			return null;
		} else {
			User newUser = getUserDao().createUser(user);
			return newUser;
		}
	}

	public User updateUser(User user) {
		if (getUserDao().getUserByEmail(user.getEmail()) == null) {
			return null;
		} else {
			User updatedUser = getUserDao().updateUser(user);
			return updatedUser;
		}	
	}

	public boolean deleteUser(long userId) {
		boolean isUserDeleted = getUserDao().delete(userId);
		return isUserDeleted;
	}
}
