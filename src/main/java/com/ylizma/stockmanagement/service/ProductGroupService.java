package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductGroupService {

    ProductGroupDetails findByCode(String code);

    List<ProductGroupDetails> findAll();

    ResponseEntity<Object> save(ProductGroupDetails p);

    ResponseEntity<Object> update(ProductGroupDetails p, String code);

    ResponseEntity<Object> delete(String id);
}
