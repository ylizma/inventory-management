package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.StockMovementDetails;
import com.ylizma.stockmanagement.model.StockMovement;
import com.ylizma.stockmanagement.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/stockmovements")
@CrossOrigin(origins = "http://localhost:8081")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @PostMapping("/add")
    public ResponseEntity<Object> saveStockMovement(@RequestBody StockMovementDetails stockMovement) throws ParseException {
        return stockMovementService.save(stockMovement);
    }

    @GetMapping("/all")
    public Page<StockMovement> getAllStockMovement(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "10") int size) {
        return stockMovementService.findAll(page, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStockMovement(@PathVariable Long id) {
        return stockMovementService.delete(id);
    }


    @GetMapping("/chart")
        public List<?> test(@RequestParam(required = false) Long id){
        System.out.println(id);
        return stockMovementService.getProductsMovement(id);
    }
}
