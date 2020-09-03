package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.WareHouseDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WareHouseService {

    WareHouseDetails findById(Long id);

    List<WareHouseDetails> findAll();

    WareHouseDetails save(WareHouseDetails p);

    WareHouseDetails update(WareHouseDetails p, Long id);

    ResponseEntity<Object> delete(Long id);
}
