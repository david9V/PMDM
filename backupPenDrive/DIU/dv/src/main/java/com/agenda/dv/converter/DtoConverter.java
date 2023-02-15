package com.agenda.dv.converter;
import com.agenda.dv.model.PersonCreateDto;
import com.agenda.dv.model.PersonListDto;
import com.agenda.dv.model.domain.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DtoConverter {
	
	private final ModelMapper modelMapper;
	
	public PersonListDto convertToDto(Person person) {
		return modelMapper.map(person, PersonListDto.class);
	}
	
	public Person convertToEntity(PersonCreateDto personCreateDto) {
		return modelMapper.map(personCreateDto, Person.class);
	}

}