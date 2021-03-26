package com.atul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atul.dao.ContactDAO;
import com.atul.domain.Contact;

public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void save(Contact contact) {
		contactDAO.save(contact);
	}

	@Override
	public void update(Integer id, Contact contact) {
		contactDAO.update(id, contact);
	}

	@Override
	public void delete(Integer id) {
		contactDAO.delete(id);
	}

	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids)
			contactDAO.delete(id);
	}

	@Override
	public List<Contact> listUserContact(Integer id) {		
		return contactDAO.findByProperty("contactId",id);
	}

	@Override
	public List<Contact> listUserContact(Integer id, String txtToSearch) {
		return contactDAO.listContactsBySearch(id, txtToSearch);
	}

}
