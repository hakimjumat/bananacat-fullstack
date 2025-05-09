package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.*;

public interface CleaningServiceRepository extends JpaRepository<CleaningServiceEntity, Long>{

    Optional<CleaningServiceEntity> findByEmailandName(String email, String name);

    List<CleaningServiceEntity> findByEmail(String email);
}
