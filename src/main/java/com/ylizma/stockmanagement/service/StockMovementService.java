package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.StockMovementDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StockMovementService {

    StockMovementDetails findById(Long id);

    List<StockMovementDetails> findAll();

    StockMovementDetails save(StockMovementDetails p);

    StockMovementDetails update(StockMovementDetails p, Long id);

    ResponseEntity<Object> delete(Long id);
}
