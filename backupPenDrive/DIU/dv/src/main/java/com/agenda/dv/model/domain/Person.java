package com.agenda.dv.model.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("tutoriales")

public class Person {

	@Id
	String id;
	String firstName;
	String lastName;
	String street;
	int postalCode;
	String city;
	LocalDate birthday;
}
