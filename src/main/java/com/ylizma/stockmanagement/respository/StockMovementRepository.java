package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement,Long> {
}
