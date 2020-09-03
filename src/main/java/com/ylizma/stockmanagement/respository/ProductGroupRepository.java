package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
}
