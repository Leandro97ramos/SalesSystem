package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "companies")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(name = "tax_id", unique = true)
    private String taxId;

    @Column(name = "global_config", columnDefinition = "TEXT")
    private String globalConfig;
}