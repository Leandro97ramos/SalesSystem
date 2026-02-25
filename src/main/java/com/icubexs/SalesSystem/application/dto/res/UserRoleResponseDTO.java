package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoleResponseDTO {
    private Long id;
    private String userName;
    private String roleName;   // Nombre del rol (ej: "ADMINISTRADOR")
    private Boolean status;
}