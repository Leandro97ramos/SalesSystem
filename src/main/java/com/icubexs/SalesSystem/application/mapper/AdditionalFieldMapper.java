package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.AdditionalFieldRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.AdditionalFieldResponseDTO;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import org.springframework.stereotype.Component;

@Component
public class AdditionalFieldMapper {

    public AdditionalField toDomain(AdditionalFieldRequestDTO request) {
        if (request == null) return null;
        return AdditionalField.builder()
                .name(request.getName())
                .description(request.getDescription())
                .attribute(request.getAttribute())
                .dataSource(ConfiguracionDet.builder().id(request.getDataSourceId()).build())
                .dataType(ConfiguracionDet.builder().id(request.getDataTypeId()).build())
                .build();
    }

    public AdditionalFieldResponseDTO toResponse(AdditionalField domain) {
        if (domain == null) return null;
        return AdditionalFieldResponseDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .attribute(domain.getAttribute())
                .dataSourceName(domain.getDataSource() != null ? domain.getDataSource().getNombre() : null)
                .dataTypeName(domain.getDataType() != null ? domain.getDataType().getNombre() : null)
                .build();
    }
}
