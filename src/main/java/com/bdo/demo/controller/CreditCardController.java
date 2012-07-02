package com.bdo.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdo.demo.domain.CreditCard;
import com.bdo.demo.service.CreditCardService;
import com.bdo.demo.service.PersonService;

@Controller
@RequestMapping("/main/creditcard")
public class CreditCardController {

	@Resource(name = "personService")
	private PersonService personService;

	@Resource(name = "creditCardService")
	private CreditCardService creditCardService;

	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public String getAdd(@RequestParam("id") Integer personId, Model model) {
		CreditCard creditCard = new CreditCard();
		creditCard.setPerson(personService.get(personId));
		model.addAttribute("creditCardAttribute", creditCard);
		return "add-credit-card";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public String postAdd(@RequestParam("id") Integer personId,
			@ModelAttribute("creditCardAttribute") CreditCard creditCardAttribute) {
		creditCardService.add(personId, creditCardAttribute);
		return "redirect:/main/record/list";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public String getEdit(@RequestParam("id") Integer creditCardId, Model model) {
		CreditCard existingCreditCard = creditCardService.get(creditCardId);
		model.addAttribute("creditCardAttribute", existingCreditCard);
		return "edit-credit-card";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public String postEdit(@RequestParam("id") Integer creditCardId,
			@ModelAttribute("creditCardService") CreditCard creditCard) {
		creditCard.setId(creditCardId);
		creditCardService.edit(creditCard);
		return "redirect:/main/record/list";
	}

}
