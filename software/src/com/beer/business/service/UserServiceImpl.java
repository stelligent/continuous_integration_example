package com.user.business.service;

import java.util.Collection;
import com.user.business.data.UserDao;
import com.user.business.data.UserDaoImpl;
import com.user.business.domain.User;
import java.util.Iterator;

public class UserServiceImpl implements UserService {

    public Collection findAll() {
        UserDao userData = new UserDaoImpl();
        Collection users = userData.findAll(UserDao.ALL_BEER);
		for (Iterator it=users.iterator(); it.hasNext(); ) {
          User user = (User)it.next();
		  System.out.println("user.getName()=" + user.getName() + "user.getBrewer()=" + user.getBrewer());
        } 
        return users;
    }

	public Collection findAllStates() {
        UserDao userData = new UserDaoImpl();
        Collection states = userData.findAllStates(UserDao.ALL_STATES);
        return states;
    }


	 public int create(User user) {
        UserDao userData = new UserDaoImpl();
        userData.create(UserDao.CREATE_BEER, user);
        return 0;
    }

	public void runThisBranch() {
		System.out.println("test");
	}

}
