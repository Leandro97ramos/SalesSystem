package com.icubexs.SalesSystem.domain.model;

public class ProductImage {

    private Long id;
    private Product product; // Relación con Product
    private String url; // URL de la imagen
    private Boolean isPrimary; // Indica si es la imagen principal
    private Integer orderIndex; // Índice para ordenar las imágenes

}
