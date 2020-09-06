package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.SupplierDetails;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface SupplierService {

    SupplierDetails findById(Long id);

    List<SupplierDetails> findAll();

    ResponseEntity<Object> save(SupplierDetails p) throws ParseException;

    ResponseEntity<Object> update(SupplierDetails p,Long id) throws ParseException;

    ResponseEntity<Object> delete(Long id);
}
