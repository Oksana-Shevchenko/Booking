package com.epam.dao;

import java.util.Date;
import java.util.List;

import com.epam.model.Event;

public interface EventDao {

	boolean deleteEvent(long eventId);

	Event updateEvent(Event event);
	
	Event createEvent(Event event);

	List<Event> getEventsForDay(Date day, int pageSize, int pageNum);

	List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

}
