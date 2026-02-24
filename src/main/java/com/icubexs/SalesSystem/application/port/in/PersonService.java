package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> findByIdentification(String identification);
    List<Person> findAll();
    void deleteById(Long id);
}