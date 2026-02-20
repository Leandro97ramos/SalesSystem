package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Data
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;

    @Column(nullable = false)
    private Long itemId;

    @Column(name = "batch_code", unique = true)
    private String batchCode;

    private LocalDateTime entryDate;
    private LocalDateTime expiryDate;

    @Column(name = "provider_id")
    private Long providerId;
}