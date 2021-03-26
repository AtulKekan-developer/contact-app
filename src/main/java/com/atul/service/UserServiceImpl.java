package com.atul.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.atul.dao.UserDAO;
import com.atul.domain.User;
import com.atul.exception.UserBlockedException;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void register(User user) {
		userDAO.save(user);
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
