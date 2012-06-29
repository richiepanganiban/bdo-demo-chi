package com.bdo.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdo.demo.domain.Person;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<Person> getAll() {
		Session session = sessionFactory.getCurrentSession();
		// Query query = session.createQuery("FROM Person");
		// return query.list();
		Criteria criteria = session.createCriteria(Person.class);
		return criteria.list();
	}

	@Override
	public void add(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.save(person);
	}

	@Override
	public Person get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Person) session.get(Person.class, id);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, id);
		session.delete(person);
	}

	@Override
	public void edit(Person person) {
		Session session = sessionFactory.getCurrentSession();
		Person existingPerson = (Person) session.get(Person.class, person.getId());
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setMoney(person.getMoney());
		session.save(existingPerson);

	}

}
