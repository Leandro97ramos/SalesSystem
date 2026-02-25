package com.icubexs.SalesSystem.application.mapper;

import com.icubexs.SalesSystem.application.dto.res.*;
import com.icubexs.SalesSystem.application.dto.req.*;
import com.icubexs.SalesSystem.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracionMapper {

    // --- Mapeos para Tipo ---
    public ConfiguracionTipoResponseDTO toTipoResponse(ConfiguracionTipo domain) {
        if (domain == null) return null;
        return ConfiguracionTipoResponseDTO.builder()
                .id(domain.getId())
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .activo(domain.getActivo())
                .build();
    }

    // --- Mapeos para Cabecera ---
    public ConfiguracionCabResponseDTO toCabResponse(ConfiguracionCab domain) {
        if (domain == null) return null;
        return ConfiguracionCabResponseDTO.builder()
                .id(domain.getId())
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .parametro(domain.getParametro())
                .activo(domain.getActivo())
                .tipoNombre(domain.getConfiguracionTipo() != null ? domain.getConfiguracionTipo().getNombre() : null)
                .build();
    }

    // --- Mapeos para Detalle ---
    public ConfiguracionDet toDomain(ConfiguracionDetRequestDTO request) {
        if (request == null) return null;
        return ConfiguracionDet.builder()
                .cabecera(ConfiguracionCab.builder().id(request.getCabeceraId()).build())
                .padre(request.getPadreId() != null ? ConfiguracionDet.builder().id(request.getPadreId()).build() : null)
                .codigo(request.getCodigo())
                .nombre(request.getNombre())
                .parametro(request.getParametro())
                .estado(request.getEstado())
                .activo(request.getActivo())
                .build();
    }

    public ConfiguracionDetResponseDTO toDetResponse(ConfiguracionDet domain) {
        if (domain == null) return null;
        return ConfiguracionDetResponseDTO.builder()
                .id(domain.getId())
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .parametro(domain.getParametro())
                .activo(domain.getActivo())
                .padreId(domain.getPadre() != null ? domain.getPadre().getId() : null)
                .cabeceraNombre(domain.getCabecera() != null ? domain.getCabecera().getNombre() : null)
                .build();
    }
}