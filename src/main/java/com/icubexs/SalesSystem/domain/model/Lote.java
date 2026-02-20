package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lote {
    private Long loteId; // [cite: 181]
    private Long itemId; // Relación con el producto [cite: 182]
    private String codigoLote; // Código de trazabilidad [cite: 183]
    private LocalDateTime fechaIngreso; // [cite: 184]
    private LocalDateTime fechaVencimiento; // [cite: 185]
    private Long proveedorId; //
}

