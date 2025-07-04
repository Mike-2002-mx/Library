package com.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.libraryproject.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhone(String phone);

}