package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.*;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long>{

    List<HistoryEntity> findByCLemail(String CLemail);

    List<HistoryEntity> findByHOemail(String HOemail);

    List<HistoryEntity> findByDate(LocalDate date);

    List<HistoryEntity> findByCLemailAndHOemailAndDateAndServiceName(String CLemail, String HOemail, LocalDate date, String serviceName);

    List<HistoryEntity> findByCLemailAndDate(String CLemail, LocalDate date);

    List<HistoryEntity> findBySdateAndEdate(LocalDate Sdate, LocalDate Edate);

    @Query("SELECT SUM(h.price) AS totalPrice, COUNT(h) AS count FROM HistoryEntity h WHERE h.date BETWEEN :start AND :end")
    Object[] getMonthlyStats(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
