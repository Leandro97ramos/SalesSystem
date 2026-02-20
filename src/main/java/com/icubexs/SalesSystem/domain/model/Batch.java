package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    private Long batchId;
    private Long itemId;
    private String batchCode; // Código de trazabilidad
    private LocalDateTime entryDate;
    private LocalDateTime expiryDate;
    private Long providerId;
}

