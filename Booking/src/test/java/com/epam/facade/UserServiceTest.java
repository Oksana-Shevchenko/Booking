package com.epam.facade;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.dao.mock.UserDaoImpl;
import com.epam.model.User;
import com.epam.model.UserImpl;
import com.epam.service.UserServiceImpl;

import static org.mockito.Mockito.*;

public class UserServiceTest {
	static UserServiceImpl userService;
	static UserDaoImpl userDao;
	
	@BeforeClass 
	public static void  initializeUserService() {
		userService = new UserServiceImpl();
		userDao = mock(UserDaoImpl.class);
		userService.setUserDao(userDao);
	}
	
	@Test
	public void deleteUser() {
		long userId=1;	

		when(userDao.delete(userId)).thenReturn(true);
		
		Assert.assertTrue(userService.deleteUser(userId));
		verify(userDao, times(1)).delete(userId);
	}
	
	@Test
	public void getUserByEmail() {
		String email = "Den25@epam.com";
		User newUser = mock(UserImpl.class);
		
		when(userDao.getUserByEmail(email)).thenReturn(newUser);

		Assert.assertNotNull(userService.getUserByEmail(email));
		verify(userDao, times(1)).getUserByEmail(email);
	}
	
	@Test
	public void createUser() {
		String email = "Ann25@epam.com";

		User user = mock(UserImpl.class);
		User newUser = mock(UserImpl.class);
		
		when(user.getEmail()).thenReturn(email);
		when(userDao.getUserByEmail(email)).thenReturn(null);
		when(userDao.createUser(user)).thenReturn(newUser);

		Assert.assertNotNull(userService.createUser(user));
		verify(userDao, times(1)).createUser(user);
	}
	
	@Test
	public void updateUser() {
		String email = "Sem25@epam.com";

		User user = mock(UserImpl.class);
		User updatedUser = mock(UserImpl.class);
		
		when(user.getEmail()).thenReturn(email);
		when(userDao.getUserByEmail(email)).thenReturn(user);
		when(userDao.updateUser(user)).thenReturn(updatedUser);

		Assert.assertNotNull(userService.updateUser(user));
		verify(userDao, times(1)).updateUser(user);
	}
	
	@Test
	public void getUsersByName() {
		String name = "Alla";
		int pageSize = 1,  pageNum = 1;
		List<User> user = mock(List.class);
		
		when(userDao.getUsersByName(name, pageSize, pageNum)).thenReturn(user);

		Assert.assertNotNull(userService.getUsersByName(name, pageSize, pageNum));
		verify(userDao, times(1)).getUsersByName(name, pageSize, pageNum);
	}
}
