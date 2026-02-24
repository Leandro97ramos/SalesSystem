package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.ProductInfo;
import java.util.List;
import java.util.Optional;

public interface ProductInfoRepository {
    ProductInfo save(ProductInfo productInfo);
    Optional<ProductInfo> findById(Long id);
    List<ProductInfo> findByProductId(Long productId);
    void deleteById(Long id);
}