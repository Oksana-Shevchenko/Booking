package com.epam.facade;

import java.util.Date;
import java.util.List;

import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.User;
import com.epam.service.EventService;
import com.epam.service.TicketService;
import com.epam.service.UserService;



public class BookingFacadeImpl implements BookinFacade {
	private EventService eventService;
	private TicketService ticketService;
	private UserService userService;
	
	public BookingFacadeImpl(EventService eventService, TicketService ticketService, UserService userService){
		this.eventService = eventService;
		this.ticketService = ticketService;
		this.userService = userService;
	}

	public Event getEventById() {
		return eventService.getEventById();
	}

	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		return eventService.getEventsByTitle(title, pageSize, pageNum);
	}

	public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
		return eventService.getEventsForDay(day, pageSize, pageNum);
	}

	public Event createEvent(Event event) {
		return eventService.createEvent(event);
	}

	public Event updateEvent(Event event) {
		return eventService.updateEvent(event);
	}

	public boolean deleteEvent(long eventId) {
		return eventService.deleteEvent(eventId);
	}

	public User getUserById() {
		return userService.getUserById();
	}

	public User getUserByEmail(String email) {
		return userService.getUserByEmail(email);
	}

	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		return userService.getUsersByName(name, pageSize, pageNum);
	}

	public User createUser(User user) {
		return userService.createUser(user);
	}

	public User updateUser(User user) {
		return userService.updateUser(user);
	}

	public boolean deleteUser(long userId) {
		return userService.deleteUser(userId);
	}

	public Ticket bookTicket(long userId, long eventId, int place,
			Category category) {
		return ticketService.bookTicket(userId, eventId, place, category);
	}

	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		return ticketService.getBookedTickets(user, pageSize, pageNum);
	}

	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		return ticketService.getBookedTickets(event, pageSize, pageNum);
	}

	public boolean cancelTicket(long ticketId) {
		return ticketService.cancelTicket(ticketId);
	}
}
