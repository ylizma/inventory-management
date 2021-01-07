package com.ylizma.stockmanagement.controller;


import com.ylizma.stockmanagement.domain.UserRoleForm;
import com.ylizma.stockmanagement.model.RoleApp;
import com.ylizma.stockmanagement.model.UserApp;
import com.ylizma.stockmanagement.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/roles")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> addNewRole(@RequestBody RoleApp role) {
        RoleApp roleApp = accountService.addNewRole(role);
        return ResponseEntity.ok(roleApp);
    }

    @PostMapping("/users")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> addRoleToUser(@RequestBody UserRoleForm userRoleForm) {

        return ResponseEntity.ok(accountService.addRoleToUser(userRoleForm));
    }

    @PutMapping("/users/{id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> updateUser(@RequestBody UserRoleForm userRoleForm, @PathVariable Long id) {
        return ResponseEntity.ok(accountService.updateUser(userRoleForm,id));
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(accountService.allUsers());
    }

    @GetMapping("/roles")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Object> getAllRoles() {
        System.out.println("/roles");
        return ResponseEntity.ok(accountService.allRoles());
    }
}
