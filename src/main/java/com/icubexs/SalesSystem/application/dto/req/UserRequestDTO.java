package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class UserRequestDTO {
    private Long personId;   // Vínculo con Persona [cite: 66]
    private Long companyId;  // Empresa a la que pertenece [cite: 70]
    private String username;
    private String password; // Se encriptará en el UseCase [cite: 68]
    private String email;
}