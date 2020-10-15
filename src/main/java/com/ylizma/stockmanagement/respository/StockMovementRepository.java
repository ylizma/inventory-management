package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    @Query("select new map(count(m.movementType) as cnt, m.product.name as name,m.movementType as movementType, m.createdAt as date) " +
            "from StockMovement m where m.product.id in (select max(s.product.id) from StockMovement s) group by m.createdAt,m.movementType")
    List<?> findProductsMovement(@Param(value="id") Long productId);

    @Query("select p from Product p where p.id = (select max(id) from Product )")
    Product getRandomProduct();
}
