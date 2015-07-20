package com.epam.service;

import java.util.List;

import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.User;

public class TicketServiceImpl implements TicketService{

	public Ticket bookTicket(long userId, long eventId, int place,
			Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean cancelTicket(long ticketId) {
		// TODO Auto-generated method stub
		return false;
	}

}
