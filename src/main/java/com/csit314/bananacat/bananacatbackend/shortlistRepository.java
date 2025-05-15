package com.csit314.bananacat.bananacatbackend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface shortlistRepository extends JpaRepository<shortlistEntity, Long> {

    Optional<shortlistEntity> findByHOemailAndCLemailAndName(String HOemail, String CLemail, String name);

    List<shortlistEntity> findByHOemail(String HOemail);

    List<shortlistEntity> findByHOemailAndName(String HOemail, String name);

    @Query("SELECT COUNT(s) FROM shortlistEntity s WHERE s.CLemail = :email AND s.name = :name" )
    int CountByEmailAndName (@Param("email") String email, @Param("name") String name);
}
