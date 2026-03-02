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

        // Mapeamos los datos de cuenta (User)
        User user = User.builder()
                .username(request.getUser().getUsername())
                .email(request.getUser().getEmail()) // ¡Aquí se soluciona el email NULL!
                .passwordHash(request.getUser().getPassword_hash())
                .build();

        // Mapeamos la persona
        Person person = Person.builder()
                .firstName(request.getPerson().getFirst_name())
                .lastName(request.getPerson().getLast_name())
                .identification(request.getPerson().getIdentification())
                .phone(request.getPerson().getPhone())
                .personalAddress(request.getPerson().getPersonal_address())
                .build();

        // Mapeamos la empresa si existe
        Company company = null;
        if (request.getCompany() != null && request.getCompany().getLegal_name() != null) {
            company = Company.builder()
                    .legalName(request.getCompany().getLegal_name())
                    .taxIdNumber(request.getCompany().getTax_id())
                    .build();
        }

        user.setPerson(person);
        user.setCompany(company);
        return user;
    }



    public UserResponseDTO toResponse(User domain) {
        if (domain == null) return null;

        String fullName = "";
        Person person = Person.builder()
                .firstName(domain.getPerson().getFirstName())
                .lastName(domain.getPerson().getLastName())
                .identification(domain.getPerson().getIdentification()) // Asegura que esté aquí
                .phone(domain.getPerson().getPhone())
                .personalAddress(domain.getPerson().getPersonalAddress()) // ¡ESTA LÍNEA FALTABA!
                .build();



        return UserResponseDTO.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .email(domain.getEmail())
                .personFullName(fullName.trim())
                .companyLegalName(domain.getCompany() != null ? domain.getCompany().getLegalName() : null)
                .build();
    }
}