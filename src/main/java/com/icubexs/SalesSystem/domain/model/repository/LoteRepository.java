package com.icubexs.SalesSystem.domain.model.repository;

import com.icubexs.SalesSystem.domain.model.Lote;
import java.util.Optional;

public interface LoteRepository {
    Lote save(Lote lote);
    Optional<Lote> findById(Long id);
}