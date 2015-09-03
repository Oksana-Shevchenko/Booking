package com.epam.facade;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.dao.mock.TicketDaoImpl;
import com.epam.model.Event;
import com.epam.model.EventImpl;
import com.epam.model.Ticket;
import com.epam.model.TicketImpl;
import com.epam.model.User;
import com.epam.model.UserImpl;
import com.epam.model.Ticket.Category;
import com.epam.service.TicketServiceImpl;

public class TicketServiceTest {
	static TicketServiceImpl ticketService;
	static TicketDaoImpl ticketDao;
	
	@BeforeClass 
	public static void  initializeTicketService() {
		ticketService =  new TicketServiceImpl();
		ticketDao = mock(TicketDaoImpl.class);
		ticketService.setTicketDao(ticketDao);
	}
	
	@Test	
	public void cancelTicket() {
		long ticketId=1;

		when(ticketDao.cancelTicket(ticketId)).thenReturn(true);
		
		Assert.assertTrue(ticketService.cancelTicket(ticketId));
		verify(ticketDao, times(1)).cancelTicket(ticketId);
	}
	
	@Test
	public void getBookedTicketsForEvent() {
		int pageSize=1, pageNum=1;
		Event event = mock(EventImpl.class);
		List<Ticket> ticketList = mock(List.class);
		
		when(ticketDao.getBookedTickets(event, pageSize, pageNum)).thenReturn(ticketList);
		
		Assert.assertNotNull(ticketService.getBookedTickets(event, pageSize, pageNum));
		verify(ticketDao, times(1)).getBookedTickets(event, pageSize, pageNum);
	}
	
	@Test
	public void getBookedTicketsForUser() {
		int pageSize=1, pageNum=1;
		User user = mock(UserImpl.class);
		List<Ticket> ticketList = mock(List.class);
		
		when(ticketDao.getBookedTickets(user, pageSize, pageNum)).thenReturn(ticketList);
		
		Assert.assertNotNull(ticketService.getBookedTickets(user, pageSize, pageNum));
		verify(ticketDao, times(1)).getBookedTickets(user, pageSize, pageNum);
	}
	
	@Test
	public void bookTicket() {
		long userId=6, eventId=6;
		int place = 222;
		Category category = Category.BAR;
		Ticket ticket = mock(TicketImpl.class);
		
		when(ticketDao.bookTicket(userId, eventId, place, category)).thenReturn(ticket);

		Assert.assertNotNull(ticketService.bookTicket(userId, eventId, place, category));
		verify(ticketDao, times(1)).bookTicket(userId, eventId, place, category);
	}
}
