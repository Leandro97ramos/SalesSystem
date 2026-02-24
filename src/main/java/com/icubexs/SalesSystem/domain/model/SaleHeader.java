package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleHeader {
    private Long id;
    private LocalDateTime saleDate;
    private BigDecimal subtotal;
    private BigDecimal totalTax;
    private BigDecimal totalSale;

    private Company company;               // company_id
    private User seller;                   // seller_user_id
    private User buyer;                    // buyer_user_id
    private ConfiguracionDet status;        // status_config_det_id
}