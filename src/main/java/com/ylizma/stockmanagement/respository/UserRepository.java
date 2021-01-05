package com.ylizma.stockmanagement.respository;

import com.ylizma.stockmanagement.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApp,Long> {
    Optional<UserApp> findUserByUsername(String userName);
}
