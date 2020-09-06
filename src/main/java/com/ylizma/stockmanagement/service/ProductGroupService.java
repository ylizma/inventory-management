package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface ProductGroupService {

    ProductGroupDetails findByCode(String code);

    List<ProductGroupDetails> findAll();

    ResponseEntity<Object> save(ProductGroupDetails p) throws ParseException;

    ResponseEntity<Object> update(ProductGroupDetails p, String code) throws ParseException;

    ResponseEntity<Object> delete(String id);
}
