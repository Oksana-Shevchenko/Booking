package com.epam.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.model.Event;
import com.epam.model.EventImpl;
import com.epam.model.Ticket;
import com.epam.model.User;
import com.epam.model.UserImpl;
import com.epam.model.Ticket.Category;
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
	
	@Test
	public void getUsersByName() {
		String name="Tina";
		int pageSize=1, pageNum=1;
		List<User> lst = bookingFacade.getUsersByName(name, pageSize, pageNum);
		Assert.assertEquals(lst.size(), 2);
	}
	
	@Test	
	public void cancelTicket() {
		long ticketId=1;
		Assert.assertTrue(bookingFacade.cancelTicket(ticketId));
	}
	
	@Test
	public void getBookedTicketsForEvent() {
		int pageSize=1, pageNum=1;
		Event event = new EventImpl();
		event.setId(7);
		//event.setTitle("4th World Congress of Dermoscopy Conference");
		//event.setDate(14325012);
		List<Ticket> lst = bookingFacade.getBookedTickets(event, pageSize, pageNum);
		Assert.assertEquals(lst.size(), 1);
	}
	
	@Test
	public void getBookedTicketsForUser() {
		int pageSize=1, pageNum=1;
		User user = new UserImpl();
		user.setId(6);
		//event.setTitle("4th World Congress of Dermoscopy Conference");
		//event.setDate(14325012);
		List<Ticket> lst = bookingFacade.getBookedTickets(user, pageSize, pageNum);
		Assert.assertEquals(lst.size(), 1);
	}
	
	@Test
	public void bookTicket() {
		long userId=6, eventId=6;
		int place = 222;
		Category category = Category.BAR;
		Ticket ticket = bookingFacade.bookTicket(userId, eventId, place, category);
		Assert.assertNotNull(ticket);
	}
	
	@Test	
	public void deleteEvent() {
		long eventId=1;
		Assert.assertTrue(bookingFacade.deleteEvent(eventId));
	}
	
	@Test
	public void updateEvent() {
		Event event = new EventImpl();
		event.setId(6);
		event.setTitle("New Title");
		event.setDate(new Date());
		Event updatedEvent = bookingFacade.updateEvent(event);
		Assert.assertNotNull(updatedEvent);
	}
	
	@Test
	public void createEvent() {
		Event event = new EventImpl();
		event.setId(8);
		event.setDate(new Date());
		event.setTitle("New Title");
		Event newEvent = bookingFacade.createEvent(event);
		Assert.assertNotNull(newEvent);
	}
	
	@Test
	public void getEventsForDay() {
		int pageSize=1, pageNum=1;
		Date dt = new Date(14324148);
		List<Event> lst = bookingFacade.getEventsForDay(dt, pageSize, pageNum);
		Assert.assertEquals(lst.size(), 2);
	}
	
	@Test
	public void getEventsByTitle() {
		int pageSize=1, pageNum=1;
		String title = "2015 ASCRS Glaucoma Day";
		List<Event> lst = bookingFacade.getEventsByTitle(title, pageSize, pageNum);
		Assert.assertEquals(lst.size(), 1);
	}
}
