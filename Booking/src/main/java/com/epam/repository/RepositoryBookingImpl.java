package com.epam.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

import com.epam.model.Event;
import com.epam.model.EventImpl;
import com.epam.model.Ticket;
import com.epam.model.TicketImpl;
import com.epam.model.User;
import com.epam.model.UserImpl;

public class RepositoryBookingImpl implements RepositoryBooking{
	private Map<String, Object> repository;
	private String fileNameEvent;
	private String fileNameTicket;
	private String fileNameUser;
	
	private static final Logger logger = LogManager.getLogger(RepositoryBookingImpl.class);
	
	public String getFileNameUser(){
		return fileNameUser;
	}
	
	public void setFileNameUser(String fileName){
		fileNameUser = fileName;
	}
	
	public String getFileNameTicket(){
		return fileNameTicket;
	}
	
	public void setFileNameTicket(String fileName){
		fileNameTicket = fileName;
	}
	
	public String getFileNameEvent(){
		return fileNameEvent;
	}
	
	public void setFileNameEvent(String fileName){
		fileNameEvent = fileName;
	}
	
	public Map<String, Object> generateRepository() {
		if (repository != null){
			return repository;
		} else {
			repository = new HashMap<String, Object>();
			repository = generate(getFileNameEvent());
			repository.putAll(generate(getFileNameTicket()));
			repository.putAll(generate(getFileNameUser()));
			return repository;
		}
	}

	private Map<String, Object> generate(String fileName) {
		StringBuilder bldr;
		File file = new File(fileName);
		logger.debug("RepositoryBookingImpl: start method generate");
		try {
			InputStream inputStream = new FileInputStream(file);
			JsonFactory jsonFactory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				Object item = null;
				JsonParser jParser = jsonFactory.createJsonParser(inputStream);
				jParser.nextToken();
				
				while (jParser.nextToken() == JsonToken.START_OBJECT) {
					bldr = new StringBuilder();
					if (fileName.equals(getFileNameEvent())) {
						item = mapper.readValue(jParser, EventImpl.class);
						bldr.append("'event:").append(((Event)item).getId()).append("'");
					} else if (fileName.equals(getFileNameTicket())) {
						item = mapper.readValue(jParser, TicketImpl.class);
						bldr.append("'ticket:").append(((Ticket)item).getId()).append("'");
					} else if (fileName.equals(getFileNameUser())) {
						item = mapper.readValue(jParser, UserImpl.class);
						bldr.append("'user:").append(((User)item).getId()).append("'");
					}
					if (item != null) {
						repository.put(bldr.toString(), item);
					}
					logger.debug("Repository item id: " + bldr.toString());
				}
			} catch (JsonProcessingException ex) {
				logger.error(ex.getMessage());
			} catch (IOException ex) {
				logger.error(ex.getMessage());
			}
		} catch (FileNotFoundException ex) {
			logger.error(ex.getMessage());
		}
		logger.debug("RepositoryBookingImpl: end method generate");
		return repository;
	}
}
