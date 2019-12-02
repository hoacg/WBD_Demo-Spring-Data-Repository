package com.codegym.services;

import com.codegym.models.User;
import com.codegym.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {

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
}
