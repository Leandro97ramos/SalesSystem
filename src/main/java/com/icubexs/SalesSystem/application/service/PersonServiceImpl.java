package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.PersonService;
import com.icubexs.SalesSystem.application.port.out.PersonRepository;
import com.icubexs.SalesSystem.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Person> findByIdentification(String identification) {
        return repository.findByIdentification(identification);
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}