package org.guanpu.todo.resources.version1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.guanpu.todo.service.Oauth2Service;
import org.guanpu.todo.service.TokenVerifierService;
import org.guanpu.todo.service.impl.Oauth2ServiceImpl;
import org.guanpu.todo.service.impl.TokenVerifierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("oauth2")
public class Oauth2Resource {
	
	@Autowired
	private Oauth2Service oauth2Service = new Oauth2ServiceImpl();
	@Autowired
	private TokenVerifierService tokenVerifierService = new TokenVerifierServiceImpl();
	
	@GET
	@Path("userinfo")
	public String getUserinfo() throws Exception{
		return oauth2Service.getUserinfo();
	}
	@GET
	@Path("verification/{token}/{accesstoken}")
	public String isValid(@PathParam("token") String token, @PathParam("accesstoken") String accesstoken) throws Exception{
		return tokenVerifierService.isValid(token, accesstoken);
	}
}
