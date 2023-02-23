package com.agenda.dv.repository;
import java.util.List;

import com.agenda.dv.model.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
    List<Person> findByFirstNameContaining(String firstName);

}
