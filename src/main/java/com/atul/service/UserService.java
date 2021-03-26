package com.atul.service;

import java.util.List;
import com.atul.domain.User;
import com.atul.exception.UserBlockedException;

public interface UserService {
	Integer LOGIN_STATUS_ACTIVE = 1;
	Integer LOGIN_STATUS_BLOCKED = 2;
	void register(User user);//new user can register
	User login(String loginName,String password) throws UserBlockedException;//user or admin can login
	List<User> getUserList();//admin can see list of users
	void changeLoginStatus(Integer userId,Integer loginStatus);//admin will change user status
}
