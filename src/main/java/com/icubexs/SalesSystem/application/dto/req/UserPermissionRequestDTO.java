package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class UserPermissionRequestDTO {
    private Long userId;
    private Long permissionConfigId; // ID de ConfiguracionDet
    private String permissionLevel;  // Ej: 'LECTURA', 'ESCRITURA'
}