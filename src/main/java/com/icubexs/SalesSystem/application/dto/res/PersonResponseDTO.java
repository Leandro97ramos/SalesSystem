package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponseDTO {
    private Long id;
    private String fullName; // Combinación de nombre y apellido
    private String identification;
    private String phone;
    private String personalAddress;
}