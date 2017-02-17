package org.guanpu.todo.service;

public interface TokenVerifierService {
	public abstract String isValid(String token, String accesstoken);
}
