package com.epam.facade;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.model.Event;
import com.epam.repository.RepositoryBooking;

public class BookingFacadeTest {
	static ApplicationContext context;
	static Map<String,Object> repository;
	static RepositoryBooking repositoryBooking;
	
	@BeforeClass 
	public static void  initializeApplicationContext(){
		context = new ClassPathXmlApplicationContext("Booking.xml");
		repositoryBooking =  (RepositoryBooking) context.getBean("repositoryBooking");
		repository = repositoryBooking.generateRepository();
	}
	
	@Test
	public void checkThatRepositoryNotEmpty(){
		Assert.assertFalse(repository.isEmpty());
	}
	
	/*public static void main(String[] args){
		System.out.println("gggg");
		context = new ClassPathXmlApplicationContext("Booking.xml");
		System.out.println("gggg");
		RepositoryBooking repositoryBooking =  (RepositoryBooking) context.getBean("repositoryBooking");
		repository = repositoryBooking.generateRepository();
		for(Entry<String, Object> jj: repository.entrySet()){
			if(jj.getKey().contains("event")){
				System.out.println(jj.getKey()+((Event)jj.getValue()).getId());
			}
		}
	}*/
	
}
