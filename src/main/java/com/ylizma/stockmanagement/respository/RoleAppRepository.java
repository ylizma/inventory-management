package com.ylizma.stockmanagement.respository;


import com.ylizma.stockmanagement.model.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAppRepository extends JpaRepository<RoleApp,Long> {
    RoleApp findByName(String name);
}
