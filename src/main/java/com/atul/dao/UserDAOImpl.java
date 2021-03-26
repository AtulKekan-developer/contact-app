package com.atul.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.atul.domain.User;

public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer save(User user) {
		Integer id = null;
		try(Session session = sessionFactory.openSession())
		{
			id = (Integer) session.save(user);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return id;
	}

	@Override
	public User findById(Integer id) {
		User user = null;
		try(Session session = sessionFactory.openSession())
		{
			user = session.get(User.class,id);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> userList = null;
		try(Session session = sessionFactory.openSession())
		{
			userList = session.createQuery("from User").list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<User> findByProperty(String propertyName, Object propertyValue) {
		List<User> userList = null;
		try(Session session = sessionFactory.openSession())
		{
			Query query = session.createQuery("from User where ?=?");
			query.setParameter(1,propertyName);
			query.setParameter(2,propertyValue);
			userList = query.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return userList;
	}

	@Override
	public void update(Integer id, User user) {
		try(Session session = sessionFactory.openSession())
		{
			User oldUser = session.load(User.class,id);
			oldUser.setAddress(user.getAddress());
			oldUser.setContactList(user.getContactList());
			oldUser.setEmail(user.getEmail());
			oldUser.setLoginName(user.getLoginName());
			oldUser.setLoginStatus(user.getLoginStatus());
			oldUser.setName(user.getName());
			oldUser.setPassword(user.getPassword());
			oldUser.setPhone(user.getPhone());
			oldUser.setRole(user.getRole());
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(Integer id) {
		try(Session session = sessionFactory.openSession())
		{
			User user = session.load(User.class,id);
			session.remove(user);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(User user) {
		try(Session session = sessionFactory.openSession())
		{
			session.remove(user);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
