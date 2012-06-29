package com.bdo.demo.service;

import java.util.List;

import com.bdo.demo.domain.CreditCard;

public interface CreditCardService {

	List<CreditCard> getAll();

	List<CreditCard> getAll(Integer personId);

	CreditCard get(Integer creditCardId);

	void add(Integer personId, CreditCard creditCard);

	void delete(Integer creditCardId);

	void deleteAll(Integer personId);

	void edit(CreditCard creditCard);

}
