package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventory")
@Data
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Column(name = "batch_id", nullable = false)
    private Long batchId;

    @Column(name = "config_detail_id", nullable = false)
    private Long configDetailId;

    @Column(name = "current_quantity")
    private Integer currentQuantity;
}
