package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchInfo {
    private Long id;
    private Long batchId; // Representa el entity_id que referencia a batch(id)
    private String value;
    private AdditionalField additionalField;
}