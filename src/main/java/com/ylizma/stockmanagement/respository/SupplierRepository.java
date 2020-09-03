package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
