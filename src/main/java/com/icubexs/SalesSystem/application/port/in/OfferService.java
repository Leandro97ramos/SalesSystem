package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Offer;
import java.util.List;
import java.util.Optional;

public interface OfferService {
    Offer save(Offer offer);
    Optional<Offer> findById(Long id);
    List<Offer> findAllActive();
    void deleteById(Long id);
}