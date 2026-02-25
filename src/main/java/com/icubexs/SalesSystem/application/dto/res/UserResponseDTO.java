package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String personFullName;
    private String companyLegalName;
}