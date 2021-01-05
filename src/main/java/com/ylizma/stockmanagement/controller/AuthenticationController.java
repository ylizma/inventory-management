package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.UserDetails;
import com.ylizma.stockmanagement.model.AuthenticationResponse;
import com.ylizma.stockmanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDetails userDetails) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword())
            );
        } catch (Exception e) {
            throw new Exception(e);
        }
        final org.springframework.security.core.userdetails.UserDetails user = userDetailsService.loadUserByUsername(userDetails.getUsername());
        final String jwt = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
