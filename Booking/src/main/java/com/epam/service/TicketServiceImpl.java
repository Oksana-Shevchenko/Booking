package com.epam.service;

import java.util.List;

import com.epam.dao.TicketDao;
import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.User;
import com.epam.repository.RepositoryBooking;

public class TicketServiceImpl implements TicketService{
	private TicketDao ticketDao;
	private RepositoryBooking repositoryBooking;
	
	public void setRepositoryBooking(RepositoryBooking repository){
		repositoryBooking = repository;
	}
	
	public RepositoryBooking getRepositoryBooking(){
		return repositoryBooking;
	}
	
	public void setTicketDao(TicketDao ticket) {
		ticketDao = ticket;
	}
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public Ticket bookTicket(long userId, long eventId, int place,
			Category category) {
		Ticket ticket = getTicketDao().bookTicket(userId, eventId, place, category);
		return ticket;
	}

	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		List<Ticket> lst = getTicketDao().getBookedTickets(user, pageSize, pageNum);
		return lst;
	}

	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		List<Ticket> lst = getTicketDao().getBookedTickets(event, pageSize, pageNum);
		return lst;
	}

	public boolean cancelTicket(long ticketId) {
		boolean isTicketCanceled = getTicketDao().cancelTicket(ticketId);
		return isTicketCanceled;
	}
}
