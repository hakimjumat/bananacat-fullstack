package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface shortlistRepository extends JpaRepository<shortlistEntity, Long> {

    Optional<shortlistEntity> findBybothEmail(String HOemail, String CLemail);

    List<shortlistEntity> findByHOemail(String HOemail);

    @Query("SELECT COUNT(s) FROM shortlistEntity s WHERE s.CLemail = :email" )
    int CountByEmail (@Param("email") String email);
}
