package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, String>{

    Optional<UserAccountEntity> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE UserAccountEntity u SET u.status = :status WHERE u.email = :email")
    void updateStatusByEmail(@Param("status") String status, @Param("email") String email);

    @Query("SELECT u.status FROM UserAccountEntity u WHERE u.email = :email")
    String findStatusByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("UPDATE UserAccountEntity u SET u.userprofile = :newProfile WHERE u.userprofile = :oldProfile")
    void UpdateUserProfile(@Param("newProfile") String newProfile, @Param("oldProfile") String oldProfile);
}
