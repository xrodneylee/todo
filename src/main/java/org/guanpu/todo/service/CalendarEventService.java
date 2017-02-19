package org.guanpu.todo.service;

import java.io.IOException;
import java.text.ParseException;

import com.google.api.services.calendar.Calendar.Events;
import com.google.api.services.calendar.model.Event;

public interface CalendarEventService {
	public abstract String list(String userInfo) throws IOException;
	public abstract void insert(String eventStr) throws IOException, ParseException;
}
