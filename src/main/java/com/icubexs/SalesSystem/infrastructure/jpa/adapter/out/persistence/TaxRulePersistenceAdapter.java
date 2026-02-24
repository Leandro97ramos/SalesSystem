package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.TaxRuleRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.GeoLocation;
import com.icubexs.SalesSystem.domain.model.TaxRule;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.GeoLocationEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.TaxRuleEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.TaxRuleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaxRulePersistenceAdapter implements TaxRuleRepository {

    private final TaxRuleJpaRepository jpaRepository;

    @Override
    public TaxRule save(TaxRule domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<TaxRule> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<TaxRule> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<TaxRule> findByGeoLocationId(Long geoLocationId) {
        return jpaRepository.findByGeoLocationId(geoLocationId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private TaxRule toDomain(TaxRuleEntity entity) {
        if (entity == null) return null;
        return TaxRule.builder()
                .id(entity.getId())
                .geoLocation(entity.getGeoLocation() != null ?
                        GeoLocation.builder().id(entity.getGeoLocation().getId()).cityName(entity.getGeoLocation().getCityName()).build() : null)
                .taxCategory(entity.getTaxCategory() != null ?
                        ConfiguracionDet.builder().id(entity.getTaxCategory().getId()).nombre(entity.getTaxCategory().getNombre()).build() : null)
                .taxValue(entity.getTaxValue() != null ?
                        ConfiguracionDet.builder().id(entity.getTaxValue().getId()).nombre(entity.getTaxValue().getNombre()).parametro(entity.getTaxValue().getParametro()).build() : null)
                .build();
    }

    private TaxRuleEntity toEntity(TaxRule domain) {
        if (domain == null) return null;
        return TaxRuleEntity.builder()
                .id(domain.getId())
                .geoLocation(domain.getGeoLocation() != null ? GeoLocationEntity.builder().id(domain.getGeoLocation().getId()).build() : null)
                .taxCategory(domain.getTaxCategory() != null ? ConfiguracionDetEntity.builder().id(domain.getTaxCategory().getId()).build() : null)
                .taxValue(domain.getTaxValue() != null ? ConfiguracionDetEntity.builder().id(domain.getTaxValue().getId()).build() : null)
                .build();
    }
}