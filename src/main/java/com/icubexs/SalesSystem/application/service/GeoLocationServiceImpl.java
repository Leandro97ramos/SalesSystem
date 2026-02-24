package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.GeoLocationService;
import com.icubexs.SalesSystem.application.port.out.GeoLocationRepository;
import com.icubexs.SalesSystem.domain.model.GeoLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeoLocationServiceImpl implements GeoLocationService {

    private final GeoLocationRepository repository;

    @Override
    public GeoLocation save(GeoLocation geoLocation) {
        // Aquí podrías agregar lógica de negocio, como validar el formato del código postal
        return repository.save(geoLocation);
    }

    @Override
    public Optional<GeoLocation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<GeoLocation> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}