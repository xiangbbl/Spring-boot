package com.example.demo1.dao;

import com.example.demo1.model.Person;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PersonDao {

    int insertPerson(Long id, Person person);

    default int insertPerson(Person person) {
        Long id = new Date().getTime();
        return insertPerson(id, person);
    }

    List<Person> getPeople();
    Optional<Person> personById(Long id);
    int updatePerson(Long id, Person person);
    int deletePerson(Long id);
}
