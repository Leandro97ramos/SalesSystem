package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.PersonRepository;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.PersonEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.PersonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonPersistenceAdapter implements PersonRepository {

    private final PersonJpaRepository jpaRepository;

    @Override
    public Person save(Person domain) {
        PersonEntity entity = toEntity(domain);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Person> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Person> findByIdentification(String identification) {
        return jpaRepository.findByIdentification(identification).map(this::toDomain);
    }

    @Override
    public List<Person> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // --- Mapeo Manual ---

    private Person toDomain(PersonEntity entity) {
        if (entity == null) return null;
        return Person.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .identification(entity.getIdentification())
                .phone(entity.getPhone())
                .personalAddress(entity.getPersonalAddress())
                .build();
    }

    public PersonEntity toEntity(Person domain) {
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setIdentification(domain.getIdentification()); // <-- CRÍTICO
        entity.setPhone(domain.getPhone());
        entity.setPersonalAddress(domain.getPersonalAddress()); // <-- CRÍTICO
        return entity;
    }
}