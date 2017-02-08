package org.guanpu.todo.resources;

import org.guanpu.todo.service.Oauth2Service;
import org.guanpu.todo.service.impl.Oauth2ServiceImpl;

public class Oauth2Test {

	public static void main(String[] args) {
		Oauth2Service test = new Oauth2ServiceImpl();
		try {
			test.getUserinfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
