package com.beer.business.data;

import junit.framework.TestCase;
import com.beer.business.data.LoginDao;
import com.beer.business.service.UserException;

public class LoginDaoComponentTest extends TestCase {

	private LoginDaoImpl loginData;

	public LoginDaoComponentTest(String name) {
		super(name);
	}

	public void setUp() {
		loginData = new LoginDaoImpl();
	}

	public void testBadUsername() {
		try {
			loginData.login(LoginDao.VERIFY_LOGIN, "baduser", "abc1234");
			fail("A bad username was passed but not caught");
		} catch (InvalidLoginException e) {
			e.printStackTrace();
		}

	}

	public void testBadPassword() {
		try {
			loginData.login(LoginDao.VERIFY_LOGIN, "burke.cox", "badpassword");
			fail("A bad password was passed but not caught");
		} catch (InvalidLoginException e) {
			e.printStackTrace();
		}

	}

	public void testGoodUsernamePassword() {
		try {
			loginData.login(LoginDao.VERIFY_LOGIN, "burke.cox", "abc1234");
		} catch (InvalidLoginException e) {
			fail("The correct information was sent, but not validate with database");
		}

	}
}
