package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement,Long> {
}
