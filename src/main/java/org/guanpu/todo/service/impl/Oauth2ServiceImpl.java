package org.guanpu.todo.service.impl;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.guanpu.todo.service.Oauth2Service;
import org.guanpu.todo.util.TodoLocalServerReceiver;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.Oauth2Scopes;

public class Oauth2ServiceImpl implements Oauth2Service {

	private static final String APPLICATION_NAME = "guanpu-todo";
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".store/oauth2_sample");
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final List<String> SCOPES = Arrays.asList(Oauth2Scopes.USERINFO_PROFILE, 
															 Oauth2Scopes.USERINFO_EMAIL);
	private static GoogleClientSecrets clientSecrets;
	private static HttpTransport HTTP_TRANSPORT;
	private static FileDataStoreFactory dataStoreFactory;
	private static UUID uuid;

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static Credential authorize() throws Exception {
		uuid = UUID.randomUUID();
	    // load client secrets
	    clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
	        new InputStreamReader(Oauth2ServiceImpl.class.getResourceAsStream("/client_secret.json")));
	    
	    // set up authorization code flow
	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	    		HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(
	    		        dataStoreFactory).build();
	    // authorize
	    return new AuthorizationCodeInstalledApp(flow, new TodoLocalServerReceiver.Builder().setPort(8083).build()).authorize(uuid.toString());
    }
	
	public Oauth2 getOauth2Service() throws Exception {
		Credential credential = authorize();
		Oauth2 oauth2Service = new Oauth2.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(
		          APPLICATION_NAME).build();
		return oauth2Service;
	}
	
	public String getUserinfo() throws Exception {
		Oauth2 service = getOauth2Service();
		return service.userinfo().v2().me().get().execute().getEmail();
	}

}
