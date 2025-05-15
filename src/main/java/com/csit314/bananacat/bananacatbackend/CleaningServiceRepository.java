package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface CleaningServiceRepository extends JpaRepository<CleaningServiceEntity, Long>{

    Optional<CleaningServiceEntity> findByEmailAndServiceName(String email, String serviceName);
    List<CleaningServiceEntity> findByEmail(String email);
}
