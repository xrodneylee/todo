package org.guanpu.todo.resources.version1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.guanpu.todo.service.Oauth2Service;
import org.guanpu.todo.service.impl.Oauth2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/oauth2")
public class Oauth2Resource {
	
	@Autowired
	private Oauth2Service oauth2Service = new Oauth2ServiceImpl();
	
	@GET
	@Path("/userinfo")
	public String getUserinfo() throws Exception{
		return oauth2Service.getUserinfo();
	}
}
