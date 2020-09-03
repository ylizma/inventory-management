package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ProductDetails findByCode(String code);

    List<ProductDetails> findAll();

    ResponseEntity<Object> save(ProductDetails p);

    ResponseEntity<Object> update(ProductDetails p,String code);

    ResponseEntity<Object> delete(String code);

}
