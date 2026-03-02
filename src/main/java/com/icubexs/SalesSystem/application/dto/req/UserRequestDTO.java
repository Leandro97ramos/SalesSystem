package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    // Usamos objetos en lugar de IDs para permitir la creación desde cero
    private PersonDTO person;
    private UserDataDTO user;
    private CompanyDTO company; // Opcional (solo para SELLER)
    private List<String> roles;

    @Data
    public static class PersonDTO {
        private String first_name;
        private String last_name;
        private String identification;
        private String phone;
        private String personal_address;
    }

    @Data
    public static class UserDataDTO {
        private String username;
        private String email;
        private String password_hash; // Coincide con el JSON de React
    }

    @Data
    public static class CompanyDTO {
        private String legal_name;
        private String tax_id;
        private String address;
    }
}