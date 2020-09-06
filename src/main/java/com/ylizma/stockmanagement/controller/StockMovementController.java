package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.StockMovementDetails;
import com.ylizma.stockmanagement.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockmovement")
public class StockMovementController {

    @Autowired
    StockMovementService stockMovementService;

    @PostMapping("/add")
    public ResponseEntity<Object> saveStockMovement(@RequestBody StockMovementDetails stockMovement) {
        return stockMovementService.save(stockMovement);
    }

    @GetMapping("/all")
    public List<StockMovementDetails> getAllStockMovement() {
        return stockMovementService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStockMovement(@PathVariable Long id) {
        return stockMovementService.delete(id);
    }
}
