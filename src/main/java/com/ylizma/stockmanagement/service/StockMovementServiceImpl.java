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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StockMovementServiceImpl implements StockMovementService {

    @Autowired
    private StockMovementRepository stockMovementRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DomainConversion domainConversion;

    @Override
    public StockMovementDetails findById(Long id) {
        Optional<StockMovement> stockM = stockMovementRepository.findById(id);
        return stockM.map(stockMovement -> domainConversion.convertStockMtoStockMdetails(stockMovement)).orElse(null);
    }

    public Page<StockMovement> findAll(int page, int size) {
        return stockMovementRepository.findAll(PageRequest.of(page, size, Sort.by("createdAt").descending()));
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

    @Override
    public List<?> getProductsMovement(Long id) {
        if (id == null) {
            System.out.println("is null");
            Product p = stockMovementRepository.getRandomProduct();
            System.out.println(p.getId());
            List<?> tes = stockMovementRepository.findProductsMovement(p.getId());
            System.out.println(Arrays.toString(tes.toArray()));
            return tes;
        }
        return stockMovementRepository.findProductsMovement(id);
    }
}
