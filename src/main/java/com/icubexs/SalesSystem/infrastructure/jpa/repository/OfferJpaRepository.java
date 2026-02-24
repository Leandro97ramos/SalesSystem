package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OfferJpaRepository extends JpaRepository<OfferEntity, Long> {
    @Query("SELECT o FROM OfferEntity o WHERE o.isActive = true AND CURRENT_TIMESTAMP BETWEEN o.startDate AND o.endDate")
    List<OfferEntity> findAllActiveAndInDate();
}
