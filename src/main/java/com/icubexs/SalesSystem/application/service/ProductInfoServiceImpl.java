package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ProductInfoService;
import com.icubexs.SalesSystem.application.port.out.ProductInfoRepository;
import com.icubexs.SalesSystem.domain.model.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInfoServiceImpl implements ProductInfoService {

    private final ProductInfoRepository repository;

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public Optional<ProductInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductInfo> findByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}