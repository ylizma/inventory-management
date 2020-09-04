package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.WareHouseDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WareHouseService {

    List<WareHouseDetails> findAll();

    List<WareHouseDetails> findByName(String name);

    ResponseEntity<Object> save(WareHouseDetails p);

    ResponseEntity<Object> update(WareHouseDetails p, Long id);

    ResponseEntity<Object> delete(Long id);
}
