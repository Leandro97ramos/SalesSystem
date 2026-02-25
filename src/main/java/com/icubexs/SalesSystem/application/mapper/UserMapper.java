package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.UserRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.UserResponseDTO;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserRequestDTO request) {
        if (request == null) return null;

        return User.builder()
                .person(Person.builder().id(request.getPersonId()).build())
                .company(Company.builder().id(request.getCompanyId()).build())
                .username(request.getUsername())
                .passwordHash(request.getPassword()) // Nota: La encriptación se hace en el Service
                .email(request.getEmail())
                .build();
    }

    public UserResponseDTO toResponse(User domain) {
        if (domain == null) return null;

        String fullName = "";
        if (domain.getPerson() != null) {
            fullName = domain.getPerson().getFirstName() + " " + domain.getPerson().getLastName();
        }

        return UserResponseDTO.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .email(domain.getEmail())
                .personFullName(fullName.trim())
                .companyLegalName(domain.getCompany() != null ? domain.getCompany().getLegalName() : null)
                .build();
    }
}