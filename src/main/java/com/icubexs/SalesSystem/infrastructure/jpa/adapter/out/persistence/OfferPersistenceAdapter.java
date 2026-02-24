package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.OfferRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.Offer;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.OfferEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.OfferJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferPersistenceAdapter implements OfferRepository {

    private final OfferJpaRepository jpaRepository;

    @Override
    public Offer save(Offer domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Offer> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Offer> findAllActive() {
        return jpaRepository.findAllActiveAndInDate().stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Offer toDomain(OfferEntity entity) {
        if (entity == null) return null;
        return Offer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .discountValue(entity.getDiscountValue())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .isActive(entity.getIsActive())
                .discountType(entity.getDiscountType() != null ?
                        ConfiguracionDet.builder().id(entity.getDiscountType().getId()).build() : null)
                .build();
    }

    private OfferEntity toEntity(Offer domain) {
        if (domain == null) return null;
        return OfferEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .discountValue(domain.getDiscountValue())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .isActive(domain.getIsActive())
                .discountType(domain.getDiscountType() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getDiscountType().getId()).build() : null)
                .build();
    }
}