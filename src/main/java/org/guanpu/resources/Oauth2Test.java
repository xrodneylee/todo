package org.guanpu.resources;

import org.guanpu.service.Oauth2Service;
import org.guanpu.service.impl.Oauth2ServiceImpl;

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
