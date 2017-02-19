package org.guanpu.todo.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.guanpu.todo.dao.EventDao;
import org.guanpu.todo.service.CalendarEventService;
import org.guanpu.todo.util.AccessTokenRepository;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
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
	
	public String list(String email) throws IOException {
		Calendar service = getCalendarService(email);
		com.google.api.services.calendar.Calendar.Events.List list = service.events().list(email);
		com.google.api.services.calendar.model.Events events = list.execute();
		for(Event event : events.getItems()){
			System.out.println(event.getSummary());
		}
		return null;
	}

	public void insert(String eventInfo) throws IOException, ParseException {
		Gson gson = new Gson();
		EventDao eventDao = gson.fromJson(eventInfo, EventDao.class);
		Event event = new Event();
		EventDateTime start = new EventDateTime();
		EventDateTime end = new EventDateTime();
		event.setSummary(eventDao.getSummary());
		event.setDescription(eventDao.getDescription());
		event.setStart(start.setDateTime(DateTime.parseRfc3339(eventDao.getStart())));
		event.setEnd(end.setDateTime(DateTime.parseRfc3339(eventDao.getEnd())));
		
		Calendar service = getCalendarService(eventDao.getEmail());
		service.events().insert(eventDao.getEmail(), event).execute();
	}

}
