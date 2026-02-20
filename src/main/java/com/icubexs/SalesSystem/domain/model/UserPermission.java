package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPermission {
    private Long userPermissionId;
    private Long userId;
    private Long configTypeId;
    private String permissionLevel;
}