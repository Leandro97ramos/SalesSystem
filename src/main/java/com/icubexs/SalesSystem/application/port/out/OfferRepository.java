package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Offer;
import java.util.List;
import java.util.Optional;

public interface OfferRepository {
    Offer save(Offer offer);
    Optional<Offer> findById(Long id);
    List<Offer> findAllActive();
    void deleteById(Long id);
}