package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.OfferProductService;
import com.icubexs.SalesSystem.application.port.out.OfferProductRepository;
import com.icubexs.SalesSystem.domain.model.OfferProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferProductServiceImpl implements OfferProductService {

    private final OfferProductRepository repository;

    @Override
    public OfferProduct save(OfferProduct offerProduct) {
        return repository.save(offerProduct);
    }

    @Override
    public List<OfferProduct> findByOfferId(Long offerId) {
        return repository.findByOfferId(offerId);
    }

    @Override
    public List<OfferProduct> findByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}