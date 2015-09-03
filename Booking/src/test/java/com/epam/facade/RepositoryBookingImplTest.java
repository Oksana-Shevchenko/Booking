package com.epam.facade;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.repository.RepositoryBookingImpl;

import static org.mockito.Mockito.*;

public class RepositoryBookingImplTest {
	static RepositoryBookingImpl repositoryBooking;
	
	@BeforeClass 
	public static void  initializeRepositoryBookingImpl() {
		RepositoryBookingImpl repository =  new RepositoryBookingImpl();
		repositoryBooking = spy(repository);
	}
	
	@Test	
	public void generateRepository() {
		repositoryBooking.generateRepository();
		when(repositoryBooking.getFileNameEvent()).thenReturn("file1");
		when(repositoryBooking.getFileNameTicket()).thenReturn("file1");
		when(repositoryBooking.getFileNameUser()).thenReturn("file1");
		Assert.assertNotNull(repositoryBooking.generateRepository());
		verify(repositoryBooking).generateRepository();
		
	}
}
