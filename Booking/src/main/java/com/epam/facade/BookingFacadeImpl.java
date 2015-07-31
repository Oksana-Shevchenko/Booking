package com.epam.facade;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.User;
import com.epam.service.EventService;
import com.epam.service.TicketService;
import com.epam.service.UserService;

public class BookingFacadeImpl implements BookingFacade {
	private EventService eventService;
	private TicketService ticketService;
	private UserService userService;
	
	private static final Logger logger = LogManager.getLogger(BookingFacadeImpl.class);
	
	public BookingFacadeImpl(EventService eventService, TicketService ticketService, UserService userService) {
		this.eventService = eventService;
		this.ticketService = ticketService;
		this.userService = userService;
	}

	public Event getEventById() {
		logger.debug("BookingFacadeImpl: start method getEventById()");
		Event event = eventService.getEventById();
		logger.debug("Output parameter: (Event="+event+")");
		logger.debug("BookingFacadeImpl: end method getEventById()");
		return event;
	}

	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		logger.debug("BookingFacadeImpl: start method getEventsByTitle()");
		logger.debug("Input parameters: (title = " + title + ", pageSize = " + pageSize + ", pageNum = " + pageNum + ")");
		List <Event> lstEvent = eventService.getEventsByTitle(title, pageSize, pageNum);
		logger.debug("Output parameter: (List of event by title = " + lstEvent + ")");
		logger.debug("BookingFacadeImpl: end method getEventsByTitle()");
		return lstEvent;
	}

	public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
		logger.debug("BookingFacadeImpl: start method getEventsForDay()");
		logger.debug("Input parameters: (day = " + day + ", pageSize = " + pageSize + ", pageNum = " + pageNum + ")");
		List <Event> lstEvent = eventService.getEventsForDay(day, pageSize, pageNum);
		logger.debug("Output parameter: (List of event by day = " + lstEvent + ")");
		logger.debug("BookingFacadeImpl: end method getEventsForDay()");
		return lstEvent;
	}

	public Event createEvent(Event event) {
		logger.debug("BookingFacadeImpl: start method createEvent()");
		logger.debug("Input parameter: (event = " + event + ")");
		Event newEvent = eventService.createEvent(event);
		logger.debug("Output parameter: (newEvent = " + newEvent + ")");
		logger.debug("BookingFacadeImpl: end method createEvent()");
		return newEvent;
	}

	public Event updateEvent(Event event) {
		logger.debug("BookingFacadeImpl: start method updateEvent()");
		logger.debug("Input parameter: (event = " + event + ")");
		Event newEvent =  eventService.updateEvent(event);
		logger.debug("Output parameter: (newEvent = " + newEvent + ")");
		logger.debug("BookingFacadeImpl: end method updateEvent()");
		return newEvent;
	}

	public boolean deleteEvent(long eventId) {
		logger.debug("BookingFacadeImpl: start method deleteEvent()");
		logger.debug("Input parameter: (event id = " + eventId + ")");
		boolean isEventDeleted = eventService.deleteEvent(eventId);
		logger.debug("Output parameter: (Is event deleted = " + isEventDeleted + ")");
		logger.debug("BookingFacadeImpl: end method deleteEvent()");
		return isEventDeleted;
	}

	public User getUserById() {
		logger.debug("BookingFacadeImpl: start method getUserById()");
		User user = userService.getUserById();
		logger.debug("Output parameter: (User = "+user + ")");
		logger.debug("BookingFacadeImpl: end method getUserById()");
		return user;
	}

	public User getUserByEmail(String email) {
		logger.debug("BookingFacadeImpl: start method getUserByEmail()");
		logger.debug("Input parameter: (email = " + email + ")");
		User user =  userService.getUserByEmail(email);
		logger.debug("Output parameter: (User = " + user + ")");
		logger.debug("BookingFacadeImpl: end method getUserByEmail()");
		return user;
	}

	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		logger.debug("BookingFacadeImpl: start method getUsersByName()");
		logger.debug("Input parameters: (name = " + name + ", pageSize = " + pageSize + ", pageNum = " + pageNum + ")");
		List <User> lstUser = userService.getUsersByName(name, pageSize, pageNum);
		logger.debug("Output parameter: (List of users by name = " + lstUser + ")");
		logger.debug("BookingFacadeImpl: end method getUsersByName()");
		return lstUser;
	}

	public User createUser(User user) {
		logger.debug("BookingFacadeImpl: start method createUser()");
		logger.debug("Input parameter: (user = " + user + ")");
		User newUser =  userService.createUser(user);
		logger.debug("Output parameter: (newUser = " + newUser + ")");
		logger.debug("BookingFacadeImpl: end method createUser()");
		return newUser;
	}

	public User updateUser(User user) {
		logger.debug("BookingFacadeImpl: start method updateUser()");
		logger.debug("Input parameter: (user = " + user + ")");
		User newUser =  userService.updateUser(user);
		logger.debug("Output parameter: (newUser = " + newUser + ")");
		logger.debug("BookingFacadeImpl: end method updateUser()");
		return newUser;
	}

	public boolean deleteUser(long userId) {
		logger.debug("BookingFacadeImpl: start method deleteUser()");
		logger.debug("Input parameter: (user id = " + userId + ")");
		boolean isUserDeleted = userService.deleteUser(userId);
		logger.debug("Output parameter: (Is user deleted = " + isUserDeleted + ")");
		logger.debug("BookingFacadeImpl: end method deleteUser()");
		return isUserDeleted;
	}

	public Ticket bookTicket(long userId, long eventId, int place, Category category) {
		logger.debug("BookingFacadeImpl: start method bookTicket()");
		logger.debug("Input parameters: (userId = " + userId + ", eventId = " + eventId + ", place = " + place + ", category = " + category + ")");
		Ticket ticket = ticketService.bookTicket(userId, eventId, place, category);
		logger.debug("Output parameter: (ticket = " + ticket + ")");
		logger.debug("BookingFacadeImpl: end method bookTicket()");
		return ticket;
	}

	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		logger.debug("BookingFacadeImpl: start method getBookedTickets()");
		logger.debug("Input parameters: (user = " + user + ", pageSize = " + pageSize + ", pageNum = " + pageNum + ")");
		List <Ticket> lstTicket =  ticketService.getBookedTickets(user, pageSize, pageNum);
		logger.debug("Output parameter: (List of booked ticket by user = " + lstTicket + ")");
		logger.debug("BookingFacadeImpl: end method getBookedTickets()");
		return lstTicket;
	}

	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		logger.debug("BookingFacadeImpl: start method getBookedTickets()");
		logger.debug("Input parameters: (event = " + event + ", pageSize = " + pageSize + ", pageNum = " + pageNum + ")");
		List <Ticket> lstTicket = ticketService.getBookedTickets(event, pageSize, pageNum);
		logger.debug("Output parameter: (List of booked ticket by event = " + lstTicket + ")");
		logger.debug("BookingFacadeImpl: end method getBookedTickets()");
		return lstTicket;
	}

	public boolean cancelTicket(long ticketId) {
		logger.debug("BookingFacadeImpl: start method cancelTicket()");
		logger.debug("Input parameter: (ticket id = " + ticketId + ")");
		boolean isTicketDeleted = ticketService.cancelTicket(ticketId);
		logger.debug("Output parameter: (Is user deleted = " + isTicketDeleted + ")");
		logger.debug("BookingFacadeImpl: end method cancelTicket()");
		return isTicketDeleted;
	}
}