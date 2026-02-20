package com.icubexs.SalesSystem.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long itemId;
    private String skuCode; // Código SKU único
    private String name;
    private String description;
    private String unitMeasure; // Unidad de medida
    private Double length; // Largo unitario
    private Double width;  // Ancho unitario
    private Double height; // Alto unitario
    private Double weight; // Peso unitario
}