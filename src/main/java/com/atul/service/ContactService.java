package com.atul.service;

import java.util.List;

import com.atul.domain.Contact;

public interface ContactService {
	void save(Contact contact);
	void update(Integer id,Contact contact);
	void delete(Integer id);
	void delete(Integer[] ids);
	List<Contact> listUserContact(Integer id);
	List<Contact> listUserContact(Integer id,String txtToSearch);
}
