package com.example.springbootwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootwebapp.model.Contact;
import com.example.springbootwebapp.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping("{id}")
	public ResponseEntity<Contact> getContact(@PathVariable(name = "id") long id) {
		return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Contact> saveContact(@RequestBody Contact c) {
		return new ResponseEntity<>(contactService.saveContact(c), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable(name = "id") long id, Contact c) {
		return new ResponseEntity<>(contactService.updateContact(id, c), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContact(long id) {
		contactService.deleteContact(id);
		return new ResponseEntity<>("Row deleted successfully!", HttpStatus.OK);
	}
}