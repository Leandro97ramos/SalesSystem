package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Long id;
    private User user;
    private ConfiguracionDet roleConfig; // Referencia al rol en configuracion_det
    private Boolean status;
}