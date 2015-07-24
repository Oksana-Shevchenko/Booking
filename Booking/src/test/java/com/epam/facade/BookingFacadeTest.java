package com.epam.facade;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.model.User;
import com.epam.model.UserImpl;
import com.epam.repository.RepositoryBooking;

public class BookingFacadeTest {
	static ApplicationContext context;
	static Map<String,Object> repository;
	static RepositoryBooking repositoryBooking;
	static BookingFacade bookingFacade;
	
	@BeforeClass 
	public static void  initializeApplicationContext() {
		context = new ClassPathXmlApplicationContext("Booking.xml");
		repositoryBooking =  (RepositoryBooking) context.getBean("repositoryBooking");
		bookingFacade = (BookingFacade)context.getBean("bookingFacade");
		repository = repositoryBooking.generateRepository();
	}
	
	@Test
	public void checkThatRepositoryNotEmpty() {
		Assert.assertFalse(repository.isEmpty());
	}
	
	@Test
	public void deleteUser() {
		long userId=1;
		Assert.assertTrue(bookingFacade.deleteUser(userId));
	}
	
	@Test
	public void getUserByEmail() {
		String email = "Den25@epam.com";
		User user = bookingFacade.getUserByEmail(email);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void createUser() {
		User user = new UserImpl();
		user.setId(7);
		user.setEmail("Luk@gmail.com");
		user.setName("Luk");
		User newUser = bookingFacade.createUser(user);
		Assert.assertNotNull(newUser);
	}
	
	@Test
	public void updateUser() {
		User user = new UserImpl();
		user.setId(6);
		user.setEmail("Den25@epam.com");
		user.setName("Sandra");
		User updatedUser = bookingFacade.updateUser(user);
		Assert.assertNotNull(updatedUser);
	}	
}
