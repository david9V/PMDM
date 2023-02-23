package com.agenda.dv.service.impl;
import java.util.List;
import java.util.Optional;

import com.agenda.dv.model.domain.Person;
import com.agenda.dv.repository.PersonRepository;
import com.agenda.dv.service.PersonService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
	
	private final PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public List<Person> listAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> findById(String id) {
		return personRepository.findById(id);
	}

	public List<Person> listByName(String firstName) {
		return personRepository.findByFirstNameContaining(firstName);
	}

	@Override
	public void deletePerson(String id) {
		personRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		personRepository.deleteAll();
	}
}
