package com.beer.business.service;

import com.beer.business.data.InvalidLoginException;
import com.beer.business.data.LoginDao;
import com.beer.business.data.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	public void login(String username, String password) throws UserException {
		System.out.println("Username is: " + username + " Password is: "
				+ password);
		LoginDao loginData = new LoginDaoImpl();
		try {
			loginData.login(loginData.VERIFY_LOGIN, username, password);
		} catch (InvalidLoginException e) {
			throw new UserException();
		}
	}
}
