package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.OfferProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OfferProductJpaRepository extends JpaRepository<OfferProductEntity, Long> {
    List<OfferProductEntity> findByOfferId(Long offerId);
    List<OfferProductEntity> findByProductId(Long productId);
}