package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Long userRoleId;
    private Long userId;
    private Long configDetailId; // El rol definido en la jerarquía (ej: Vendedor)
    private Boolean status; // Estado activo/inactivo
}