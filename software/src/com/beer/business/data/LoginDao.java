package com.beer.business.data;

public interface LoginDao {

	String VERIFY_LOGIN = "SELECT * from user where username =? AND password =? ";

	public void login(String sql, String username, String password)
			throws InvalidLoginException;

}
