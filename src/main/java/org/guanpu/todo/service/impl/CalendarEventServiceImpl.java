package org.guanpu.todo.service.impl;

import java.io.IOException;

import org.guanpu.todo.service.CalendarEventService;
import org.guanpu.todo.util.AccessTokenRepository;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.gson.Gson;

public class CalendarEventServiceImpl implements CalendarEventService {

	private static final String APPLICATION_NAME = "guanpu-todo";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static HttpTransport HTTP_TRANSPORT;
	private AccessTokenRepository accessTokens = AccessTokenRepository.getInstance();

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Calendar getCalendarService(String email){
		GoogleCredential credential = new GoogleCredential().setAccessToken(accessTokens.get(email).toString());
		Calendar calendar = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
	                .setApplicationName(APPLICATION_NAME)
	                .build();
		return calendar;
	}
	
	public String list(String userInfo) throws IOException {
		//userInfo include email
		Calendar service = getCalendarService(userInfo);
		
		com.google.api.services.calendar.Calendar.Events.List list = service.events().list(userInfo);
		com.google.api.services.calendar.model.Events events = list.execute();
		for(Event event : events.getItems()){
			System.out.println(event.getSummary());
		}
		return null;
	}

	public void insert(String eventStr) throws IOException {
		Calendar service = getCalendarService(eventStr);
		Event event = new Event();
		event = event.getFactory().fromString(eventStr, Event.class);
		service.events().insert(eventStr, event);
	}

}
