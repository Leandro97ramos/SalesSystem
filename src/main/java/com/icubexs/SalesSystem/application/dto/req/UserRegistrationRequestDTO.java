package com.icubexs.SalesSystem.application.dto.req;

import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.domain.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserRegistrationRequestDTO {
    private Person person;   // Tu clase de dominio Person
    private User user;       // Tu clase de dominio User
    private Company company; // Tu clase de dominio Company
    private List<String> roles;
}