package cn.com.study.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.study.entity.Person;
import cn.com.study.mapper.PersonMapper;

@Service
public class PersonService {

	@Autowired
	private PersonMapper personMapper;

	public List<Person> getAll() {
		return personMapper.getAll();
	}

	public int insert(Person person) {
		try {
			person.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(person.getDateStr()));
		} catch (ParseException e) {
		}

		return personMapper.insertPerson(person);
	}
}
