package com.icubexs.SalesSystem.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "batch_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BatchInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_id") // Referencia a batch(id)
    private Long batchId;

    @Column(columnDefinition = "TEXT")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "additional_field_id")
    private AdditionalFieldEntity additionalField;
}