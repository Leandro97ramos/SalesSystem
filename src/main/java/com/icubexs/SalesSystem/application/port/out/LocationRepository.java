package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Location;
import java.util.Optional;

public interface LocationRepository {
        Location save(Location location);
        Optional<Location> findById(Long id);
        Optional<Location> findByName(String name);


}
