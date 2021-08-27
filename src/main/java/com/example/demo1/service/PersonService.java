package com.example.demo1.service;

import com.example.demo1.dao.PersonDao;
import com.example.demo1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Qualifier("per1")
    private PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getPeople(){
        return personDao.getPeople();
    }

    public Optional<Person> personById(Long id){
        return personDao.personById(id);
    }

    public int deletePerson(Long id){
        return personDao.deletePerson(id);
    }

    public int updatePerson(Long id, Person person){
        return personDao.updatePerson(id, person);
    }
}
