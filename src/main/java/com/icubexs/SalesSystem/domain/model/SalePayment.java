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
public class SalePayment {
    private Long id;
    private SaleHeader sale;                  // sale_id
    private ConfiguracionDet paymentMethod;   // payment_method_config_det_id
    private BigDecimal amountPaid;
    private String transactionReference;
}