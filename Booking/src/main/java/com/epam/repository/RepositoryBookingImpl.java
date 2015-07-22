package com.epam.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
		try {
			InputStream inputStream = new FileInputStream(file);
			JsonFactory jsonFactory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				JsonParser jParser = jsonFactory.createJsonParser(inputStream);
				jParser.nextToken();
				Object item = null;
				
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
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return repository;
	}
	/*public static void main(String[] args) {
	RepositoryBookingImpl bb = new RepositoryBookingImpl();
	Map<String, Object> h= bb.generateRepository();
	for(Entry<String, Object> jj: h.entrySet()){
		if(jj.getKey().contains("event")){
			System.out.println(jj.getKey()+((Event)jj.getValue()).getId());
		}
	}
	}*/
}
