package com.epam.facade;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.dao.mock.EventDaoImpl;
import com.epam.model.Event;
import com.epam.model.EventImpl;
import com.epam.service.EventServiceImpl;

import static org.mockito.Mockito.*;

public class EventServiceTest {
	static EventServiceImpl eventService;
	static EventDaoImpl eventDao;
	
	@BeforeClass 
	public static void  initializeEventService() {
		eventService =  new EventServiceImpl();
		eventDao = mock(EventDaoImpl.class);
		eventService.setEventDao(eventDao);
	}
	
	@Test	
	public void deleteEvent() {
		long eventId=1;	
		
		when(eventDao.deleteEvent(eventId)).thenReturn(true);
		
		Assert.assertTrue(eventService.deleteEvent(eventId));
		verify(eventDao, times(1)).deleteEvent(eventId);
	}
	
	@Test
	public void updateEvent() {
		Event event = mock(EventImpl.class);
		Event updatedEvent = mock(EventImpl.class);
		
		when(eventDao.updateEvent(event)).thenReturn(updatedEvent);
		
		Assert.assertNotNull(eventService.updateEvent(event));
		verify(eventDao, times(1)).updateEvent(event);
	}
	
	@Test
	public void createEvent() {
		Event event = mock(EventImpl.class);
		Event newEvent = mock(EventImpl.class);
		
		when(eventDao.createEvent(event)).thenReturn(newEvent);
		
		Assert.assertNotNull(eventService.createEvent(event));
		verify(eventDao, times(1)).createEvent(event);
	}
	
	@Test
	public void getEventsForDay() {
		int pageSize=1, pageNum=1;
		Date dt = new Date(14324148);
		List<Event> eventList = mock(List.class);
		
		when(eventDao.getEventsForDay(dt, pageSize, pageNum)).thenReturn(eventList);
		
		Assert.assertNotNull(eventService.getEventsForDay(dt, pageSize, pageNum));
		verify(eventDao, times(1)).getEventsForDay(dt, pageSize, pageNum);
	}
	
	@Test
	public void getEventsByTitle() {	
		int pageSize=1, pageNum=1;
		String title = "2015 ASCRS Glaucoma Day";
		List<Event> eventList = mock(List.class);
		
		when(eventDao.getEventsByTitle(title, pageSize, pageNum)).thenReturn(eventList);
		
		Assert.assertNotNull(eventService.getEventsByTitle(title, pageSize, pageNum));
		verify(eventDao, times(1)).getEventsByTitle(title, pageSize, pageNum);
	}
}
