package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class UserRoleRequestDTO {
    private Long userId;
    private Long roleConfigId; // ID de ConfiguracionDet
    private Boolean status;
}