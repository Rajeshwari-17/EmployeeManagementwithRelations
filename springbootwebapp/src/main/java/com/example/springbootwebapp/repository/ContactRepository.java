package com.example.springbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootwebapp.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
