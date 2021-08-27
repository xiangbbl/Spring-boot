package com.example.demo1.dao;

import com.example.demo1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("per1")
public class PersonDataAccess implements PersonDao{

    private final List<Person> list = new ArrayList<>();

    @Override
    public int insertPerson(Long id, Person person) {
        list.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPeople() {
        return list;
    }

    @Override
    public Optional<Person> personById(Long id) {
        return list.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePerson(Long id, Person person) {
        int indexOfPerson = list.indexOf(personById(id).get());
        if(indexOfPerson>=0){
            list.set(indexOfPerson, new Person(id, person.getName()));
            return 1;
        }
        else{
            return 0;
        }

        /*return personById(id)
                .map(p->{
                    if(indexOfPerson>=0){
                        int indexOfPerson1 = list.indexOf(p);
                        list.set(indexOfPerson, person);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);*/
    }

    @Override
    public int deletePerson(Long id) {
        Optional<Person> deletePerson = personById(id);
        if(deletePerson.isEmpty()){
            return 0;
        }
        list.remove(deletePerson.get());
        return 0;
    }
}
