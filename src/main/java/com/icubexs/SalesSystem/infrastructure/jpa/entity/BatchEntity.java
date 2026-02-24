package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "batch")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @Column(nullable = false, length = 100)
    private String code;

    @Column(name = "invoice_number", length = 100)
    private String invoiceNumber;

    @Column(name = "initial_quantity", nullable = false)
    private Integer initialQuantity;

    @Column(name = "current_quantity", nullable = false)
    private Integer currentQuantity;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;
}