package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.model.WareHouse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WareHouseService {

    List<WareHouse> findAll();

    List<WareHouse> findByName(String name);

    ResponseEntity<Object> save(WareHouse p);

    ResponseEntity<Object> update(WareHouse p, Long id);

    ResponseEntity<Object> delete(Long id);
}
