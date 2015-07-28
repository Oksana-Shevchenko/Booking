package com.epam.dao;

import com.epam.model.Event;

public interface EventDao {

	boolean deleteEvent(long eventId);

	Event updateEvent(Event event);
	
	Event createEvent(Event event);

}
