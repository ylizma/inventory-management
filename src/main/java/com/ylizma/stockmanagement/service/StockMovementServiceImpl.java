package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.StockMovementDetails;
import com.ylizma.stockmanagement.model.MovementType;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.StockMovement;
import com.ylizma.stockmanagement.respository.ProductRepository;
import com.ylizma.stockmanagement.respository.StockMovementRepository;
import com.ylizma.stockmanagement.service.helper.DomainConversion;
import com.ylizma.stockmanagement.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockMovementServiceImpl implements StockMovementService {

    @Autowired
    StockMovementRepository stockMovementRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DomainConversion domainConversion;

    @Override
    public StockMovementDetails findById(Long id) {
        Optional<StockMovement> stockM = stockMovementRepository.findById(id);
        return stockM.map(stockMovement -> domainConversion.convertStockMtoStockMdetails(stockMovement)).orElse(null);
    }

    @Override
    public List<StockMovementDetails> findAll() {
        List<StockMovementDetails> stockMovementDetailsList = new ArrayList<>();
        stockMovementRepository.findAll()
                .forEach(stockMovement -> stockMovementDetailsList
                        .add(domainConversion.convertStockMtoStockMdetails(stockMovement)));
        return stockMovementDetailsList;
    }

    @Override
    public ResponseEntity<Object> save(StockMovementDetails p) throws ParseException {
        StockMovement stockMovement = domainConversion.convertStockMDetailstoStockM(p);
        Optional<Product> product = productRepository.findProductByCode(stockMovement.getProduct().getCode());
        if (product.isPresent()) {
            if ((stockMovement.getMovementType().equals(MovementType.OUTCOMING))) {
                if (stockMovement.getQuantity() > product.get().getQuantity()) {
                    return ResponseEntity.badRequest().body("no enough items in the stock !");
                } else {
                    product.get().setQuantity(product.get().getQuantity() - stockMovement.getQuantity());
                    stockMovement.setProduct(product.get());
                }
            } else {
                product.get().setQuantity(product.get().getQuantity() + stockMovement.getQuantity());
                stockMovement.setProduct(product.get());
            }
            stockMovement.setCreatedAt(DateFormatter.getCurrentDate());
            stockMovement.setLastModified(DateFormatter.getCurrentDate());
            stockMovementRepository.save(stockMovement);
            return ResponseEntity.status(HttpStatus.CREATED).body(stockMovement);
        } else {
            return ResponseEntity.badRequest().body("cannot find Product");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        Optional<StockMovement> stockM = stockMovementRepository.findById(id);
        if (stockM.isPresent()) {
            stockMovementRepository.deleteById(id);
            return ResponseEntity.ok("StockMovement Deleted !");
        } else {
            return ResponseEntity.badRequest().body("Stock movement not found !");
        }
    }
}
