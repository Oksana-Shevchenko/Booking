package com.epam.dao;

import java.util.List;

import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.User;

public interface TicketDao {

	boolean cancelTicket(long ticketId);

	List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);
	List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

	Ticket bookTicket(long userId, long eventId, int place, Category category);
}
