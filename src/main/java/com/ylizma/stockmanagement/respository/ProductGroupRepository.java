package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
    Optional<ProductGroup> findProductGroupByCode(String code);
}