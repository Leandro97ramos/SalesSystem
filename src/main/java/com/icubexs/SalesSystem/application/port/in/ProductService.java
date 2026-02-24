package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findBySku(String sku);
    List<Product> findAll();
    void deleteById(Long id);
}