package com.bdo.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdo.demo.domain.CreditCard;
import com.bdo.demo.domain.Person;

@Service("creditCardService")
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<CreditCard> getAll() {
		Session session = sessionFactory.getCurrentSession();
		// Query query = session.createQuery("FROM CreditCard");
		// return query.list();
		Criteria criteria = session.createCriteria(CreditCard.class);
		return criteria.list();
	}

	@Override
	public List<CreditCard> getAll(Integer personId) {
		Session session = sessionFactory.getCurrentSession();
		// Query query = session.createQuery("FROM CreditCard WHERE person.id="
		// + personId);
		// return query.list();
		Criteria criteria = session.createCriteria(CreditCard.class);
		criteria.add(Restrictions.eq("id", personId));
		return criteria.list();
	}

	@Override
	public CreditCard get(Integer creditCardId) {
		Session session = sessionFactory.getCurrentSession();
		return (CreditCard) session.get(CreditCard.class, creditCardId);
	}

	@Override
	public void add(Integer personId, CreditCard creditCard) {
		Session session = sessionFactory.getCurrentSession();
		Person existingPerson = (Person) session.get(Person.class, personId);
		creditCard.setPerson(existingPerson);
		session.save(creditCard);
	}

	@Override
	public void delete(Integer creditCardId) {
		Session session = sessionFactory.getCurrentSession();
		CreditCard creditCardToDelete = (CreditCard) session.get(CreditCard.class, creditCardId);
		session.delete(creditCardToDelete);
	}

	@Override
	public void deleteAll(Integer personId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM CreditCard where person.id" + personId);
		query.executeUpdate();
	}

	@Override
	public void edit(CreditCard creditCard) {
		Session session = sessionFactory.getCurrentSession();
		CreditCard existingCreditCard = (CreditCard) session.get(CreditCard.class, creditCard.getId());
		existingCreditCard.setNumber(creditCard.getNumber());
		existingCreditCard.setType(creditCard.getType());
		session.save(existingCreditCard);
	}

}
