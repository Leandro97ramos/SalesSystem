package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.UserRoleRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.UserRoleResponseDTO;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.domain.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapper {
    public UserRole toDomain(UserRoleRequestDTO request) {
        if (request == null) return null;
        return UserRole.builder()
                .user(User.builder().id(request.getUserId()).build())
                .roleConfig(ConfiguracionDet.builder().id(request.getRoleConfigId()).build())
                .status(request.getStatus())
                .build();
    }

    public UserRoleResponseDTO toResponse(UserRole domain) {
        if (domain == null) return null;
        return UserRoleResponseDTO.builder()
                .id(domain.getId())
                .userName(domain.getUser() != null ? domain.getUser().getUsername() : null)
                .roleName(domain.getRoleConfig() != null ? domain.getRoleConfig().getNombre() : null)
                .status(domain.getStatus())
                .build();
    }
}