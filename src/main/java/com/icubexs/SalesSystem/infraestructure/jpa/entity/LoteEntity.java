package com.icubexs.SalesSystem.infraestructure.jpa.entity;

@Entity
@Table(name = "lotes")
@Data
public class LoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loteId; // [cite: 181]

    @Column(nullable = false)
    private Long itemId; // [cite: 182]

    @Column(unique = true)
    private String codigoLote; // [cite: 183]

    private LocalDateTime fechaIngreso; // [cite: 184]
    private LocalDateTime fechaVencimiento; // [cite: 185]
    private Long proveedorId; //
}