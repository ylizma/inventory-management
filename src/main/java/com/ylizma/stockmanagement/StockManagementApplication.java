package com.ylizma.stockmanagement;

import com.ylizma.stockmanagement.model.RoleApp;
import com.ylizma.stockmanagement.model.UserApp;
import com.ylizma.stockmanagement.respository.RoleAppRepository;
import com.ylizma.stockmanagement.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class StockManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockManagementApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(UserRepository userAppRepository, RoleAppRepository roleAppRepository, PasswordEncoder passwordEncoder){
        return args -> {
            RoleApp admin = new RoleApp();
            admin.setName("ADMIN");
            roleAppRepository.save(admin);
            RoleApp user = new RoleApp();
            user.setName("USER");
            roleAppRepository.save(user);
            UserApp user1 = new UserApp(null,"admin",passwordEncoder.encode("admin"),admin);
            UserApp user2 = new UserApp(null,"user",passwordEncoder.encode("user"),user);
            userAppRepository.save(user1);
            userAppRepository.save(user2);
        };
    }
}
