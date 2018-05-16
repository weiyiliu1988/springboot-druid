package cn.com.study.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.study.entity.Person;
import cn.com.study.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	private Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@RequestMapping("/all")
	public @ResponseBody List<Person> getPersionAllList() {

		return personService.getAll();
	}

	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public int personSave(Person person) {
		System.out.println(person.getName());
		System.out.println(person.getDateStr());
		logger.debug(person.getName());
		return personService.insert(person);
	}
}
