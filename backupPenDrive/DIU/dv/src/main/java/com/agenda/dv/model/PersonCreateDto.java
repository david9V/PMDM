package com.agenda.dv.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonCreateDto {

	@Id
	String id;
	String firstName;
	String lastName;
	String street;
	int postalCode;
	String city;
	LocalDate birthday;
}
