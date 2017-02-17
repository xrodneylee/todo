package org.guanpu.todo.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.guanpu.todo.service.TokenVerifierService;
import org.guanpu.todo.util.AccessTokenRepository;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public class TokenVerifierServiceImpl implements TokenVerifierService{

	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static HttpTransport HTTP_TRANSPORT;

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String isValid(String token, String accesstoken) {
	
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(HTTP_TRANSPORT, JSON_FACTORY)
									.setAudience(Collections.singletonList("22413843311-hl8i1742jli5b6h1oer2hkr07vg5hrui.apps.googleusercontent.com"))
									.build();

		GoogleIdToken idToken;
		String isValid = "false";
		
		try {
			idToken = verifier.verify(token);
		
			if (idToken != null) {
				
			    Payload payload = idToken.getPayload();
			    String email = payload.getEmail();
		
			    AccessTokenRepository accessTokens = AccessTokenRepository.getInstance();
			    accessTokens.put(email, accesstoken);
			  
			    isValid = "true";
			  
//			  GoogleCredential credential = new GoogleCredential().setAccessToken(accesstoken);
//			  Calendar calendar = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
//		                .setApplicationName("guanpu-todo")
//		                .build();
//			  com.google.api.services.calendar.Calendar.Events.List list = calendar.events().list(email);
//			  Events events = list.execute();
//			  for(Event event : events.getItems()){
//				  System.out.println(event.getSummary());
//			  }
			} else {
			    throw new Exception("Invalid ID token.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isValid;
	}

}
