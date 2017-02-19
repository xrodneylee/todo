package org.guanpu.todo.dao;

import java.io.Serializable;

import com.google.api.client.util.DateTime;

public class EventDao  implements Serializable  {

	private static final long serialVersionUID = -3461679632092873770L;
	private String summary;
	private String description;
	private String email;
	private String start;
	private String end;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
