package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPermission {
    private Long id;
    private User user;
    private ConfiguracionDet permissionConfig; // Referencia a configuracion_det
    private String permissionLevel;            // Ej: 'LECTURA', 'ESCRITURA'
}