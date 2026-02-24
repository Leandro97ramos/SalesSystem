package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "inventory_transfer_detail")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InventoryTransferDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_transfer_id")
    private InventoryTransferEntity inventoryTransfer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal quantity;
}