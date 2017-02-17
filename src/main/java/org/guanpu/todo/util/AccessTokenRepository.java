package org.guanpu.todo.util;

import java.util.HashMap;
import java.util.Map;

public class AccessTokenRepository extends HashMap {
	
	private static AccessTokenRepository instance = new AccessTokenRepository();
	
	private AccessTokenRepository(){
		
	}
	
	public static AccessTokenRepository getInstance(){
		return instance;
	}
}
