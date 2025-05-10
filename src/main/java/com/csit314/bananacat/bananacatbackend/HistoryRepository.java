package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.*;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long>{

    List<HistoryEntity> findByCLemail(String CLemail);

    List<HistoryEntity> findByDate(LocalDate date);

    List<HistoryEntity> findByAll(String CLemail, String HOemail, LocalDate date, String serviceName);

    Optional<HistoryEntity> findById(Long Id);
}
