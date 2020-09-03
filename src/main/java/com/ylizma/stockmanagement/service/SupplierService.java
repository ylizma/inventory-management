package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.SupplierDetails;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface SupplierService {

    SupplierDetails findById(Long id);

    List<SupplierDetails> findAll();

    SupplierDetails save(SupplierDetails p);

    SupplierDetails update(SupplierDetails p,Long id);

    ResponseEntity<Object> delete(Long id);
}
