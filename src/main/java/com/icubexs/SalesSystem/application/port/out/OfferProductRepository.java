package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.OfferProduct;
import java.util.List;
import java.util.Optional;

public interface OfferProductRepository {
    OfferProduct save(OfferProduct offerProduct);
    List<OfferProduct> findByOfferId(Long offerId);
    List<OfferProduct> findByProductId(Long productId);
    Optional<OfferProduct> findById(Long id);
    void deleteById(Long id);
}