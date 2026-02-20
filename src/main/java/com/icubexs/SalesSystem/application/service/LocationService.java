package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Location;
import com.icubexs.SalesSystem.application.port.out.LocationRepository;

import java.util.Optional;

public class LocationService {
    private LocationRepository locationRepository;

    //register
    public Location registerLocation(Location location) {

        return locationRepository.save(location);
    }

    public Optional<Location> findById(long id) {

        return locationRepository.findById(id);
    }

}
