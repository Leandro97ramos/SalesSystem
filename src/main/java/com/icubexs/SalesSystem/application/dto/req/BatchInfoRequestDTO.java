package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class BatchInfoRequestDTO {
    private Long batchId;
    private Long additionalFieldId;
    private String value;
}