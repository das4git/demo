package com.example.demo.service;

import com.example.demo.db.PersonDB;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDB personDB;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDB personDB) {
        this.personDB = personDB;
    }

    public int addPerson(Person person) {
        return personDB.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDB.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDB.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDB.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDB.updatePersonById(id, newPerson);
    }
}
