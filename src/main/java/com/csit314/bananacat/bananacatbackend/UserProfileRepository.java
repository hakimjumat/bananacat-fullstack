package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, String> {

    Optional<UserProfileEntity> findByName(String name);
}
