package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {
    List<WareHouse> findWareHouseByNameContains(String name);

    @Query("select new map(count(p) as pcnt,p.wareHouse.name as whName) from Product p group by p.wareHouse.name")
    List<?> numberOfProductsByWareHouse();
}
