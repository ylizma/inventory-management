package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
    Optional<ProductGroup> findProductGroupByCode(String code);
}
