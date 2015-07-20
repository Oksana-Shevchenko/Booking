package com.epam.service;

import java.util.Date;
import java.util.List;

import com.epam.model.Event;

public interface EventService {
	
	Event getEventById();
	List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
	List<Event> getEventsForDay(Date day, int pageSize, int pageNum);
	Event createEvent(Event event);
	Event updateEvent(Event event);
	boolean deleteEvent(long eventId);
}
