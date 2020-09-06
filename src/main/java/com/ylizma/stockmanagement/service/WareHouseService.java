package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.WareHouseDetails;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface WareHouseService {

    List<WareHouseDetails> findAll();

    List<WareHouseDetails> findByName(String name);

    ResponseEntity<Object> save(WareHouseDetails p) throws ParseException;

    ResponseEntity<Object> update(WareHouseDetails p, Long id) throws ParseException;

    ResponseEntity<Object> delete(Long id);
}
