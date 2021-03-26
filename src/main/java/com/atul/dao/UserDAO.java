package com.atul.dao;

import java.util.List;
import com.atul.domain.Contact;
import com.atul.domain.User;

public interface UserDAO {
	Integer save(User user);
	User findById(Integer id);
	List<User> findAll();
	List<User> findByProperty(String propertyName,Object propertyValue);
	void update(Integer id,User user);
	void delete(Integer id);
	void delete(User user);
}
