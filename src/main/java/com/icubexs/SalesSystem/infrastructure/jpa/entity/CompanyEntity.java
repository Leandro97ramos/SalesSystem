package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tax_id_number", length = 50, unique = true, nullable = false)
    private String taxIdNumber;

    @Column(name = "legal_name", length = 200, nullable = false)
    private String legalName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_company_id")
    private CompanyEntity parentCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_configuration_det_id")
    private ConfiguracionDetEntity typeConfiguration;
}