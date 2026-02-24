package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.OfferProduct;
import java.util.List;
import java.util.Optional;

public interface OfferProductService {
    OfferProduct save(OfferProduct offerProduct);
    List<OfferProduct> findByOfferId(Long offerId);
    List<OfferProduct> findByProductId(Long productId);
    void deleteById(Long id);
}