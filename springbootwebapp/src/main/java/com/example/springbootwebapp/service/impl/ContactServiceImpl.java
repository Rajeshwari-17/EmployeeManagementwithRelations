package com.example.springbootwebapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwebapp.exception.ResourceNotFoundException;
import com.example.springbootwebapp.model.Contact;
import com.example.springbootwebapp.model.Employee;
import com.example.springbootwebapp.repository.ContactRepository;
import com.example.springbootwebapp.service.ContactService;
import com.example.springbootwebapp.service.EmployeeService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact c) {
		Employee e = c.getEmp();
		long id = e.getId();
		if (employeeService.hasEmployee(id)) {
			c.setEmp(employeeService.getEmployeeById(id));
			return contactRepository.save(c);

		} else
			throw new ResourceNotFoundException("Employee", "id", e.getId());
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContact(long id) {
		Optional<Contact> con = contactRepository.findById(id);
		if (con.isPresent()) {
			return con.get();
		} else
			throw new ResourceNotFoundException("Contact", "id", id);
	}

	@Override
	public Contact updateContact(long id, Contact c) {
		Optional<Contact> con = contactRepository.findById(id);
		if (con.isPresent()) {
			Contact contact = con.get();
			contact.setEmp(c.getEmp());
			contact.setPhoneNo(c.getPhoneNo());
			return contactRepository.save(contact);
		} else
			throw new ResourceNotFoundException("Contact", "id", id);
	}

	@Override
	public void deleteContact(long id) {
		Optional<Contact> con = contactRepository.findById(id);
		if (con.isPresent()) {
			contactRepository.deleteById(id);
		} else
			throw new ResourceNotFoundException("Contact", "id", id);
	}

}
