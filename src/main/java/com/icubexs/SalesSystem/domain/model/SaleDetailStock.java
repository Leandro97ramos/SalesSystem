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
public class SaleDetailStock {
    private Long id;
    private SaleDetail saleDetail; // sale_detail_id
    private Stock stock;           // stock_id
    private Item item;             // item_id (opcional para seriados)
    private BigDecimal quantity;
}