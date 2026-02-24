package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.GeoLocation;
import java.util.List;
import java.util.Optional;

public interface GeoLocationRepository {
    // Guarda o actualiza una localización en la base de datos
    GeoLocation save(GeoLocation geoLocation);

    // Recupera una localización por su identificador único
    Optional<GeoLocation> findById(Long id);

    // Obtiene el listado completo de localizaciones registradas
    List<GeoLocation> findAll();

    // Elimina un registro de localización
    void deleteById(Long id);
}