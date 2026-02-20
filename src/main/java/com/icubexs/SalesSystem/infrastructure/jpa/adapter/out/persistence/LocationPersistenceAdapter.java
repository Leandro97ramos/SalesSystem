package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.domain.model.Location;
import com.icubexs.SalesSystem.application.port.out.LocationRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.LocationEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.LocationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationRepository {


    private final LocationJpaRepository jpaRepository;

    @Override
    public Location save(Location location) {
        LocationEntity entity = new LocationEntity();
        // Mapeo manual de campos
        entity.setName(location.getName());
        entity.setAddress(location.getAddress());
        entity.setCity(location.getCity());
        entity.setState(location.getState());
        entity.setPostalCode(location.getPostalCode());
        entity.setCountry(location.getCountry());

        LocationEntity saved = jpaRepository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<Location> findById(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Optional<Location> findByName(String name) {
        return jpaRepository.findByName(name).map(this::mapToDomain);
    }

    private Location mapToDomain(LocationEntity entity) {
        return new Location(
                entity.getLocationId(), entity.getName(), entity.getAddress(),
                entity.getCity(), entity.getState(), entity.getPostalCode(), entity.getCountry()
        );
    }
}
