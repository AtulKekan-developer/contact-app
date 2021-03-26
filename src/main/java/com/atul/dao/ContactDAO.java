package com.atul.dao;

import java.util.List;
import com.atul.domain.Contact;

public interface ContactDAO {
	Integer save(Contact contact);
	Contact findById(Integer id);
	List<Contact> findAll();
	List<Contact> findByProperty(String propertyName,Object propertyValue);
	void update(Integer id,Contact contact);
	void delete(Integer id);
	void delete(Contact contact);
	List<Contact> listContactsBySearch(Integer id,String textToSearch);
}
