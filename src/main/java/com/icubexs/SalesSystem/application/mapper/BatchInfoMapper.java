package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.req.BatchInfoRequestDTO;
import com.icubexs.SalesSystem.application.dto.res.BatchInfoResponseDTO;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.BatchInfo;
import org.springframework.stereotype.Component;

@Component
public class BatchInfoMapper {
    public BatchInfo toDomain(BatchInfoRequestDTO request) {
        if (request == null) return null;
        return BatchInfo.builder()
                .batchId(request.getBatchId())
                .value(request.getValue())
                .additionalField(AdditionalField.builder().id(request.getAdditionalFieldId()).build())
                .build();
    }

    public BatchInfoResponseDTO toResponse(BatchInfo domain) {
        if (domain == null) return null;
        return BatchInfoResponseDTO.builder()
                .id(domain.getId())
                .batchId(domain.getBatchId())
                .value(domain.getValue())
                .fieldName(domain.getAdditionalField() != null ? domain.getAdditionalField().getName() : null)
                .build();
    }
}