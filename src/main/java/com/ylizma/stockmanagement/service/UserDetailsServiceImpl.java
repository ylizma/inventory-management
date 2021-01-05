package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.ylizma.stockmanagement.model.User> user = userRepository.findUserByUserName(userName);
        return user.map(value -> new User(value.getUserName(), value.getPassword(),getAuthority(value)))
                .orElseThrow(() -> new UsernameNotFoundException(userName + " Not found !!!"));
    }

    private Collection<? extends GrantedAuthority> getAuthority(com.ylizma.stockmanagement.model.User user) {
        Set auth = new HashSet();
        auth.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return auth;
    }

}
