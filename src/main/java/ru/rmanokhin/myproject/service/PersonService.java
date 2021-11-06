package ru.rmanokhin.myproject.service;

import ru.rmanokhin.myproject.entity.persons.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);

    List<Person> getAllPerson();

    void deletePersonById(Long id);

    Person updatePerson(Person person);

}
