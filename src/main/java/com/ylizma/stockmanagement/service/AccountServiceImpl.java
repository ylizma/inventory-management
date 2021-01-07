package com.ylizma.stockmanagement.service;


import com.ylizma.stockmanagement.domain.UserRoleForm;
import com.ylizma.stockmanagement.model.RoleApp;
import com.ylizma.stockmanagement.model.UserApp;
import com.ylizma.stockmanagement.respository.RoleAppRepository;
import com.ylizma.stockmanagement.respository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    private final UserRepository userAppRepository;
    private final RoleAppRepository roleAppRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(UserRepository userAppRepository, RoleAppRepository roleAppRepository, PasswordEncoder passwordEncoder) {
        this.userAppRepository = userAppRepository;
        this.roleAppRepository = roleAppRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserApp addNewUser(UserApp user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userAppRepository.save(user);
    }

    @Override
    public RoleApp addNewRole(RoleApp role) {
        return roleAppRepository.save(role);
    }

    @Override
    public UserApp addRoleToUser(UserRoleForm userApp) {
        RoleApp role = roleAppRepository.findByName(userApp.getRole());
        UserApp user = addNewUser(userApp.getUser());
        user.setRole(role);
        return userAppRepository.save(user);
    }

    @Override
    public UserApp loadUserByUsername(String username) {
        return userAppRepository.findUserByUsername(username).get();
    }

    @Override
    public List<UserApp> allUsers() {
        return userAppRepository.findAll();
    }

    @Override
    public List<RoleApp> allRoles() {
        return roleAppRepository.findAll();
    }

    @Override
    public UserApp updateUser(UserRoleForm userRoleForm, Long id) {
        UserApp user = userAppRepository.findById(id).get();
        user.setRole(roleAppRepository.findByName(userRoleForm.getRole()));
        user.setUsername(userRoleForm.getUser().getUsername());
        System.out.println("====================>"+userRoleForm.getUser().getPassword());
        if (userRoleForm.getUser().getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userRoleForm.getUser().getPassword()));
        }
        return userAppRepository.save(user);
    }
}
