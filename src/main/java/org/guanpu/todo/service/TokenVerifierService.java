package org.guanpu.todo.service;

public interface TokenVerifierService {
	public abstract boolean isValid(String token, String accesstoken);
}
