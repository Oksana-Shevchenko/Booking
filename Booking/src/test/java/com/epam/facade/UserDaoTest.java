package com.epam.facade;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.dao.mock.UserDaoImpl;
import com.epam.model.User;
import com.epam.model.UserImpl;
import com.epam.repository.RepositoryBooking;
import com.epam.repository.RepositoryBookingImpl;

public class UserDaoTest {
	static UserDaoImpl userDao;
	static RepositoryBooking repositoryBooking;
	static Map<String, Object> mp;
	
	@BeforeClass 
	public static void  initializeUserDao() {
		 userDao = new UserDaoImpl();
		 repositoryBooking = mock(RepositoryBookingImpl.class);
		 userDao.setRepositoryBooking(repositoryBooking);
		 
		 mp = mock(HashMap.class);
	}
	
	@Test
	public void delete() {
		long userId=1;
		String key = "'user:" + userId + "'";

		User newUser = mock(UserImpl.class);

		when(repositoryBooking.generateRepository()).thenReturn(mp);
		when(repositoryBooking.generateRepository().containsKey(key)).thenReturn(true);
		when(repositoryBooking.generateRepository().remove(key)).thenReturn(newUser);
		Assert.assertTrue(userDao.delete(userId));
		verify(mp, times(1)).remove(key);
	}
	
	@Test
	public void getUserByEmail() {
		String email = "Den25@epam.com";

		when(repositoryBooking.generateRepository()).thenReturn(mp);
		//when(repositoryBooking.generateRepository().entrySet().iterator().next()).thenReturn();
		//Assert.assertNotNull(userDao.getUserByEmail(email));
		//verify(mp, times(1)).entrySet().iterator().next().getValue();
	}
}
