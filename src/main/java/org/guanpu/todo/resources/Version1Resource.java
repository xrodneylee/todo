package org.guanpu.todo.resources;

import javax.ws.rs.Path;

import org.guanpu.todo.resources.version1.Oauth2Resource;

@Path("v1")
public class Version1Resource {
	
	@Path("oauth2")
	public Class<Oauth2Resource> getAdminResource() {
		return Oauth2Resource.class;
	}
}
