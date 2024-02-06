package com.example.springbootwebapp.service;

import java.util.List;

import com.example.springbootwebapp.model.Contact;

public interface ContactService {

	Contact saveContact(Contact c);

	List<Contact> getAllContacts();

	Contact getContact(long id);

	Contact updateContact(long id, Contact c);

	void deleteContact(long id);

}
