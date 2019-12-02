package com.codegym.repositories;

import com.codegym.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
