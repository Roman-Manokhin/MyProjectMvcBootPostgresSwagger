package ru.rmanokhin.myproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rmanokhin.myproject.entity.persons.Person;
import ru.rmanokhin.myproject.entity.roles.Role;
import ru.rmanokhin.myproject.repository.PersonRepository;
import ru.rmanokhin.myproject.service.PersonService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.getAllPerson();
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}
