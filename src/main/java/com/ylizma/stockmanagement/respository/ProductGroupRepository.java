package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
    Optional<ProductGroup> findProductGroupByCode(String code);
    List<ProductGroup> findAllByOrderByCreatedAtDesc();
}
