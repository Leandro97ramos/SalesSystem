package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.OfferService;
import com.icubexs.SalesSystem.application.port.out.OfferRepository;
import com.icubexs.SalesSystem.domain.model.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repository;

    @Override
    public Offer save(Offer offer) {
        return repository.save(offer);
    }

    @Override
    public Optional<Offer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Offer> findAllActive() {
        return repository.findAllActive();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}