package com.epam.dao.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.epam.dao.TicketDao;
import com.epam.model.Event;
import com.epam.model.Ticket;
import com.epam.model.Ticket.Category;
import com.epam.model.TicketImpl;
import com.epam.model.User;
import com.epam.repository.RepositoryBooking;

public class TicketDaoImpl implements TicketDao {
	private RepositoryBooking repositoryBooking;
	
	public void setRepositoryBooking(RepositoryBooking repository){
		repositoryBooking = repository;
	}
	
	public RepositoryBooking getRepositoryBooking() {
		return repositoryBooking;
	}
	
	public boolean cancelTicket(long ticketId) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String key = "'ticket:" + ticketId + "'"; 
		if (!repository.containsKey(key)) {
			return false;
		} else {
			repository.remove(key);
			return true;
		}		
	}

	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		List<Ticket> lst = new ArrayList<Ticket>();
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		for (Entry<String, Object> item: repository.entrySet()) {
			if (item.getKey().contains("ticket")) {
				if (((Ticket)item.getValue()).getEventId() == event.getId()) {
					lst.add((Ticket) item.getValue());
				}
			}
		}
		return lst;
	}
	
	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		List<Ticket> lst = new ArrayList<Ticket>();
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		for (Entry<String, Object> item: repository.entrySet()) {
			if (item.getKey().contains("ticket")) {
				if (((Ticket)item.getValue()).getUserId() == user.getId()) {
					lst.add((Ticket) item.getValue());
				}
			}
		}
		return lst;
	}

	public Ticket bookTicket(long userId, long eventId, int place, Category category) {
		Ticket ticket = new TicketImpl();
		ticket.setId(new Date().getTime());
		ticket.setCategory(category);
		ticket.setUserId(userId);
		ticket.setPlace(place);
		ticket.setEventId(eventId);
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String ticketId = "'ticket:" + ticket.getId()+"'";
		repository.put(ticketId, ticket);
		Ticket newTicket = (Ticket) repository.get(ticketId);
		return newTicket;
	}
}
