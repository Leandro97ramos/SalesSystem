package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.GeoLocationRepository;
import com.icubexs.SalesSystem.domain.model.GeoLocation;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.GeoLocationEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.GeoLocationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GeoLocationPersistenceAdapter implements GeoLocationRepository {

    private final GeoLocationJpaRepository jpaRepository;

    @Override
    public GeoLocation save(GeoLocation domain) {
        GeoLocationEntity entity = toEntity(domain);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<GeoLocation> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<GeoLocation> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // --- Mapeo Manual ---

    private GeoLocation toDomain(GeoLocationEntity entity) {
        if (entity == null) return null;
        return GeoLocation.builder()
                .id(entity.getId())
                .cityName(entity.getCityName())
                .regionCountry(entity.getRegionCountry())
                .postalCode(entity.getPostalCode())
                .build();
    }

    private GeoLocationEntity toEntity(GeoLocation domain) {
        if (domain == null) return null;
        return GeoLocationEntity.builder()
                .id(domain.getId())
                .cityName(domain.getCityName())
                .regionCountry(domain.getRegionCountry())
                .postalCode(domain.getPostalCode())
                .build();
    }
}