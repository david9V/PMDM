package com.agenda.dv.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.agenda.dv.converter.DtoConverter;
import com.agenda.dv.model.PersonCreateDto;
import com.agenda.dv.model.PersonListDto;
import com.agenda.dv.model.domain.Person;
import com.agenda.dv.service.impl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class PersonController {

	private final PersonServiceImpl personServiceImpl;

	private final DtoConverter dtoConverter;

	@PostMapping("/person")
	public ResponseEntity<?> createPerson(@RequestBody PersonCreateDto PersonDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(personServiceImpl.savePerson(dtoConverter.convertToEntity(PersonDto)));
	}

	@GetMapping("/person")
	public ResponseEntity<?> listAllPersons() {
		List<Person> result = personServiceImpl.listAllPersons();
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<PersonListDto> dtoList = result.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}

	@GetMapping("/personLength")
	public ResponseEntity<?> getListLength() {
		List<Person> result = personServiceImpl.listAllPersons();
			return ResponseEntity.ok(result.size());
	}

	@GetMapping("/person/id/{id}")
	public ResponseEntity<?> listById(@PathVariable String id) {
		Optional<Person> opt = personServiceImpl.findById(id);
		try {
			Person t = opt.get();
			return ResponseEntity.ok(t);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/person/name/{firstName}")
	public ResponseEntity<?> listByFirstName(@PathVariable String firstName) {
		List<Person> result = personServiceImpl.listByName(firstName);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<PersonListDto> dtoList = result.stream().map(dtoConverter::convertToDto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}

	@PutMapping("/person/{id}")
	public ResponseEntity<?> updatePerson(@RequestBody PersonCreateDto PersonDto, @PathVariable String id) {
		Optional<Person> opt = personServiceImpl.findById(id);
		try {
			Person t = opt.get();
			t.setFirstName(PersonDto.getFirstName());
			t.setLastName(PersonDto.getLastName());
			t.setStreet(PersonDto.getStreet());
			t.setPostalCode(PersonDto.getPostalCode());
			t.setCity(PersonDto.getCity());
			t.setBirthday(PersonDto.getBirthday());
			return ResponseEntity.ok(personServiceImpl.savePerson(t));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/person/{id}")
	public void deletePersonById(@PathVariable String id) {
		personServiceImpl.deletePerson(id);
	}

	@DeleteMapping("/person")
	public void deleteAll() {
		personServiceImpl.deleteAll();
	}

}
