package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, java.lang.String> {

    // User findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
}
