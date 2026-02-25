package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.PersonRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.PersonResponseDTO;
import com.icubexs.SalesSystem.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public Person toDomain(PersonRequestDTO request) {
        if (request == null) return null;
        return Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .identification(request.getIdentification())
                .phone(request.getPhone())
                .personalAddress(request.getPersonalAddress())
                .build();
    }

    public PersonResponseDTO toResponse(Person domain) {
        if (domain == null) return null;
        return PersonResponseDTO.builder()
                .id(domain.getId())
                .fullName(domain.getFirstName() + " " + domain.getLastName())
                .identification(domain.getIdentification())
                .phone(domain.getPhone())
                .personalAddress(domain.getPersonalAddress())
                .build();
    }
}