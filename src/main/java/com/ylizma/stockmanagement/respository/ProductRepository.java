package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByCode(String code);

    List<Product> findAllByWareHouseId(Long id);

}
