package com.icubexs.SalesSystem.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long itemId;
    private String codigoSku;
    private String nombre;
    private String descripcion;
    private String medida;
    // Dimensiones propias del producto para validación de espacio
    private Double largo;
    private Double ancho;
    private Double alto;
    private Double peso;
}