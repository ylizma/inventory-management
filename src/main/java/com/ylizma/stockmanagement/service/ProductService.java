package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductDetails;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface ProductService {

    ProductDetails findByCode(String code);

    List<ProductDetails> findAll();

    List<ProductDetails> findAllByWareHouseId(Long id);

    ResponseEntity<Object> save(ProductDetails p) throws ParseException;

    ResponseEntity<Object> update(ProductDetails p,String code) throws ParseException;

    ResponseEntity<Object> delete(String code);

}
