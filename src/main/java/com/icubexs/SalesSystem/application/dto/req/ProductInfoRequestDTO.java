package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;

@Data
public class ProductInfoRequestDTO {
    private Long productId;
    private Long additionalFieldId;
    private String value;
}