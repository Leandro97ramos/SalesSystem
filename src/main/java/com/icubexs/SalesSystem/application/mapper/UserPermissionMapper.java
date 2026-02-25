package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.UserPermissionRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.UserPermissionResponseDTO;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.domain.model.UserPermission;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionMapper {
    public UserPermission toDomain(UserPermissionRequestDTO request) {
        if (request == null) return null;
        return UserPermission.builder()
                .user(User.builder().id(request.getUserId()).build())
                .permissionConfig(ConfiguracionDet.builder().id(request.getPermissionConfigId()).build())
                .permissionLevel(request.getPermissionLevel())
                .build();
    }

    public UserPermissionResponseDTO toResponse(UserPermission domain) {
        if (domain == null) return null;
        return UserPermissionResponseDTO.builder()
                .id(domain.getId())
                .userName(domain.getUser() != null ? domain.getUser().getUsername() : null)
                .permissionName(domain.getPermissionConfig() != null ? domain.getPermissionConfig().getNombre() : null)
                .permissionLevel(domain.getPermissionLevel())
                .build();
    }
}