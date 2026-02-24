package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> findByIdentification(String identification);
    List<Person> findAll();
    void deleteById(Long id);
}