package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.model.RoleApp;
import com.ylizma.stockmanagement.model.UserApp;

import java.util.List;

public interface AccountService {

    UserApp addNewUser(UserApp user);

    RoleApp addNewRole(RoleApp role);

    void addRoleToUser(String username, String roleName);

    UserApp loadUserByUsername(String username);

    List<UserApp> allUsers();

    List<RoleApp> allRoles();
}
