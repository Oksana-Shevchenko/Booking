package com.epam.service;

import java.util.Date;
import java.util.List;

import com.epam.dao.EventDao;
import com.epam.model.Event;
import com.epam.repository.RepositoryBooking;

public class EventServiceImpl implements EventService{
	private RepositoryBooking repositoryBooking;
	private EventDao eventDao;
	
	public void setEventDao(EventDao event){
		eventDao = event;
	}
	
	public EventDao getEventDao() {
		return eventDao;
	}
	
	public void setRepositoryBooking(RepositoryBooking repository){
		repositoryBooking = repository;
	}
	
	public RepositoryBooking getRepositoryBooking(){
		return repositoryBooking;
	}
	
	public Event getEventById() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		List<Event> lst = getEventDao().getEventsByTitle(title, pageSize, pageNum);
		return lst;
	}

	public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
		List<Event> lst = getEventDao().getEventsForDay(day, pageSize, pageNum);
		return lst;
	}

	public Event createEvent(Event event) {
		Event newEvent = getEventDao().createEvent(event);
		return newEvent;
	}

	//TODO: insert checking for exist
	public Event updateEvent(Event event) {
		Event updatedEvent = getEventDao().updateEvent(event);
		return updatedEvent;
	}

	public boolean deleteEvent(long eventId) {
		boolean isEventDeleted = getEventDao().deleteEvent(eventId);
		return isEventDeleted;
	}

}
