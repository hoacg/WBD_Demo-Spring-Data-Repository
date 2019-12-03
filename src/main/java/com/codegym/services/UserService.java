package com.codegym.services;

import com.codegym.models.User;
import com.codegym.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService, UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                roles
        );
    }
}
