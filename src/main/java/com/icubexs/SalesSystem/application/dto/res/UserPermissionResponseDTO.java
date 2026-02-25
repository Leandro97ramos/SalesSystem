package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPermissionResponseDTO {
    private Long id;
    private String userName;
    private String permissionName;   // Nombre de la funcionalidad (ej: "Ventas")
    private String permissionLevel;  // Nivel de acceso
}