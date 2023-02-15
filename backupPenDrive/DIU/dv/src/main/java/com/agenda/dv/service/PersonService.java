package com.agenda.dv.service;
import com.agenda.dv.model.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
	
	public Person savePerson(Person person);
	
	public List<Person> listAllPersons();
	
	public Optional<Person> findById(String id);

	public void deletePerson(String id);
	
	public void deleteAll();
}
