package com.bdo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdo.demo.domain.Person;
import com.bdo.demo.dto.PersonDto;
import com.bdo.demo.service.CreditCardService;
import com.bdo.demo.service.PersonService;

@Controller
@RequestMapping("/main/record")
public class MainController {

	@Resource(name = "personService")
	private PersonService personService;

	@Resource(name = "creditCardService")
	private CreditCardService creditCardService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String getRecords(Model model) {
		List<Person> allPersons = personService.getAll();
		List<PersonDto> personsDto = new ArrayList<PersonDto>();
		for (Person person : allPersons) {
			PersonDto personDto = new PersonDto();
			personDto.setId(person.getId());
			personDto.setFirstName(person.getFirstName());
			personDto.setLastName(person.getLastName());
			personDto.setMoney(person.getMoney());
			personDto.setCreditCards(creditCardService.getAll(person.getId()));

			personsDto.add(personDto);
		}

		model.addAttribute("persons", personsDto);
		return "records";

	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public String getAdd(Model model) {
		model.addAttribute("personAttribute", new Person());
		return "add-record";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public String postAdd(@ModelAttribute("personAttribute") Person personAttribute) {
		personService.add(personAttribute);
		return "redirect:/main/record/list";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.POST })
	public String delete(@RequestParam("id") Integer personId) {
		creditCardService.deleteAll(personId);
		personService.delete(personId);
		return "redirect:/main/record/list";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public String getEdit(@RequestParam("id") Integer personId, Model model) {
		Person existingPerson = personService.get(personId);
		model.addAttribute("personAttribute", existingPerson);
		return "edit-record";
	}

	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public String postEdit(@RequestParam("id") Integer personId, @ModelAttribute("personAttribute") Person person) {
		person.setId(personId);
		personService.edit(person);
		return "redirect:/main/record/list";
	}
}
