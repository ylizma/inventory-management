package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {
    List<WareHouse> findWareHouseByNameContains(String name);

}
