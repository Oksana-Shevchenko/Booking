package com.epam.dao.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.dao.EventDao;
import com.epam.model.Event;
import com.epam.repository.RepositoryBooking;

public class EventDaoImpl implements EventDao{
	private RepositoryBooking repositoryBooking;
	
	public void setRepositoryBooking(RepositoryBooking repository){
		repositoryBooking = repository;
	}
	
	public RepositoryBooking getRepositoryBooking() {
		return repositoryBooking;
	}
	
	public boolean deleteEvent(long eventId) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String key = "'event:" + eventId + "'";
		if (!repository.containsKey(key)) {
			return false;
		} else {
			repository.remove(key);
			return true;
		}
	}

	public Event updateEvent(Event event) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String eventId = "'event:" + event.getId()+"'";
		Event updatedEvent = (Event) repository.get(eventId);
		updatedEvent.setTitle(event.getTitle());
		updatedEvent.setDate(event.getDate());
		repository.put(eventId, updatedEvent);
		return updatedEvent;
	}

	public Event createEvent(Event event) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		String eventId = "'event:" + event.getId()+"'";
		repository.put(eventId, event);
		Event newEvent = (Event) repository.get(eventId);
		return newEvent;
	}

	public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		List<Event> lst = new ArrayList<Event>();
		for (Entry<String, Object> item: repository.entrySet()) {
			if (item.getKey().contains("event")) {
				if (((Event)item.getValue()).getDate().equals(day)) {
					lst.add((Event)item.getValue());
				}
			}
		}
		return lst;
	}

	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		Map<String, Object> repository = getRepositoryBooking().generateRepository();
		List<Event> lst = new ArrayList<Event>();
		for (Entry<String, Object> item: repository.entrySet()) {
			if (item.getKey().contains("event")) {
				if (((Event)item.getValue()).getTitle().equals(title)) {
					lst.add((Event)item.getValue());
				}
			}
		}
		return lst;
	}
}
