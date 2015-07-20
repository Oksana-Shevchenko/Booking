package com.epam.service;

import java.util.List;

import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.User;
import com.epam.model.Ticket.Category;

public interface TicketService {
	Ticket bookTicket(long userId, long eventId, int place,	Category category);
	List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);
	List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);
	boolean cancelTicket(long ticketId);
}
