package com.bdo.demo.service;

import java.util.List;

import com.bdo.demo.domain.Person;

public interface PersonService {

	List<Person> getAll();

	void add(Person person);

	Person get(Integer id);

	void delete(Integer id);

	void edit(Person person);

}
