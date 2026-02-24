package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.GeoLocation;
import java.util.List;
import java.util.Optional;

public interface GeoLocationService {
    // Para registrar nuevas ciudades o actualizar regiones
    GeoLocation save(GeoLocation geoLocation);

    // Búsqueda por ID para relaciones con Warehouse o TaxRule
    Optional<GeoLocation> findById(Long id);

    // Listado general para selectores en el frontend
    List<GeoLocation> findAll();

    // Eliminación de registros de localización
    void deleteById(Long id);
}