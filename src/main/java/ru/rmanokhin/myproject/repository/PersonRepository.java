package ru.rmanokhin.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rmanokhin.myproject.entity.persons.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select e from person e inner join fetch e.roles")
    List<Person> getAllPerson();



}