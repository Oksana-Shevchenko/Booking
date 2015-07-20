package com.epam.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RepositoryBookingImpl implements RepositoryBooking{

	private String getValue(Element parent, String childName) {
		return childName;
		
	}
	public Map<String, String> parse(String fileName) {
		try {
			InputStream pInput = new FileInputStream("RepositoryBooking.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(pInput);
			Element root = document.getDocumentElement();
			NodeList storageNodes = root.getElementsByTagName("storage");

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		RepositoryBooking repositoryBooking = new RepositoryBookingImpl();
		repositoryBooking.parse("hhh");
	}
	
}
