package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public Optional<Product> findProductByCode(String code);
}
