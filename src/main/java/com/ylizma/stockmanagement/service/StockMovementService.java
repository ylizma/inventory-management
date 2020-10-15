package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.StockMovementDetails;
import com.ylizma.stockmanagement.model.StockMovement;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface StockMovementService {

    StockMovementDetails findById(Long id);

    Page<StockMovement> findAll(int page, int size);

    ResponseEntity<Object> save(StockMovementDetails p) throws ParseException;

    ResponseEntity<Object> delete(Long id);

    List<?> getProductsMovement(Long id);
}
