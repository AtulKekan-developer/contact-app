package com.atul.dao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atul.domain.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer save(Contact contact) 
	{
		Integer id = null;
		try(Session session = sessionFactory.openSession())
		{
			id = (Integer) session.save(contact);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println("Error!!! "+e.getMessage());
		}
		return id;
	}

	public Contact findById(Integer id) {
		Contact contact = null;
		try(Session session = sessionFactory.openSession())
		{
			contact = session.get(Contact.class,id);
		}
		catch(Exception e)
		{
			System.out.println("Error!!! "+e.getMessage());
		}
		return contact;
	}

	public List<Contact> findAll() {
		List<Contact> contactList = null;
		try(Session session = sessionFactory.openSession())
		{
			contactList = session.createQuery("from Contact").list();
		}
		catch(Exception e)
		{
			System.out.println("Error!!! "+e.getMessage());
		}
		return contactList;
	}

	public List<Contact> findByProperty(String propertyName, Object propertyValue) 
	{
		List<Contact> contactList = null;
		try(Session session = sessionFactory.openSession())
		{
			Query query = session.createQuery("from Contact where ?=?");
			query.setParameter(0,propertyName);
			query.setParameter(1,propertyValue);
			contactList = query.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return contactList;
	}

	public void update(Integer id, Contact contact) {
		try(Session session = sessionFactory.openSession())
		{
			Contact oldContact = session.load(Contact.class,id);
			oldContact.setAddress(contact.getAddress());
			oldContact.setEmail(contact.getEmail());
			oldContact.setName(contact.getName());
			oldContact.setPhone(contact.getPhone());
			oldContact.setRemark(contact.getRemark());
			oldContact.setUser(contact.getUser());
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void delete(Integer id) {
		try(Session session = sessionFactory.openSession())
		{
			Contact contact = session.load(Contact.class,id);
			session.remove(contact);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void delete(Contact contact) {
		try(Session session = sessionFactory.openSession())
		{			
			session.remove(contact);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Contact> listContactsBySearch(Integer id, String textToSearch) {
		List<Contact> contactList = null;
		try(Session session = sessionFactory.openSession())
		{
			Query query = session.createQuery("from Contact c where c.contactId = :id and (c.name like :name or c.phone like :phone or c.email like "
					+ ":email or c.address like :address or c.remark like :remark)");
			query.setParameter("id",id);
			query.setParameter("phone","%"+textToSearch+"%");
			query.setParameter("email","%"+textToSearch+"%");
			query.setParameter("address","%"+textToSearch+"%");
			query.setParameter("remark","%"+textToSearch+"%");
			contactList = query.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return contactList;
	}
}
