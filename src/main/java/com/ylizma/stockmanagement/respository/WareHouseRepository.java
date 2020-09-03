package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {
}
