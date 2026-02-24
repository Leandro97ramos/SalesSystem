package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {
    private Long id;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal appliedTaxRate; // El % del impuesto al momento de la venta
    private BigDecimal taxAmount;     // El monto calculado del impuesto
    private BigDecimal discountAmount;
    private BigDecimal total;

    private SaleHeader sale;           // sale_id
    private Product product;           // product_id
    private Offer offer;               // offer_id (opcional)
    private ConfiguracionDet taxRate;  // tax_rate_config_det_id (referencia al tipo de impuesto)
}