package com.csit314.bananacat.bananacatbackend;

import java.time.LocalDate;
import java.time.YearMonth;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.*;

@Entity
@Table(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CLemail;
    private String HOemail;
    private LocalDate date;
    private String serviceName; //match with cleaning service service name
    private Integer price;
    private Integer rating; //1 to 5
    private String review;
    private String duration;

    public Long getId() { return id; }
    public String getCLemail() { return CLemail; }
    public String getHOemail() { return HOemail; }
    public LocalDate getDate() { return date; }
    public String getServiceName() { return serviceName; }
    public Integer getPrice() { return price; }
    public Integer getRating() { return rating; }
    public String getReview() { return review; }
    public String getDuration() { return duration; }
    public void setCLemail(String CLemail) { this.CLemail = CLemail; }

    //User Story #92
    public ResponseEntity<?> ViewHistoryListForCleaner() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        List<HistoryEntity> result = Hrepository.findAll();
        return ResponseEntity.ok(result);
    }

    //User Story #23
    public ResponseEntity<?> ViewHistoryListForHO() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        List<HistoryEntity> result = Hrepository.findAll();
        return ResponseEntity.ok(result);
    }

    //User Story not yet created
    public ResponseEntity<?> ViewHistoryIndividual() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        List<HistoryEntity> result = Hrepository.findByCLemailAndHOemailAndDateAndServiceName(this.CLemail, this.HOemail, this.date, this.serviceName);
        return ResponseEntity.ok(result);
    }

    //daily report
    public ResponseEntity<?> DailyReport() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        List<HistoryEntity> result = Hrepository.findByCLemailAndDate(this.CLemail, this.date);
        return ResponseEntity.ok(result);
    }

    //weekly report
    public ResponseEntity<?> WeeklyReport() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        LocalDate sdate = this.date.minusWeeks(1);
        LocalDate edate = this.date;
        List<HistoryEntity> result = Hrepository.findByDateBetween(sdate, edate);
        return ResponseEntity.ok(result);
    }

    //monthly report, watchout when json send over the data, makesure the the date includes the day as well so that the json can be accepted by the entity, can be any day, as long as the month is correct. ONLY APPLIES TO MONTHLY REPORT
    public ResponseEntity<?> MonthlyReport() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        YearMonth target = YearMonth.from(this.date);
        LocalDate start = target.atDay(1);
        LocalDate end = target.atEndOfMonth();
        Object[] result = Hrepository.getMonthlyStats(start, end);

        Integer TotalEarnings = ((Number) result[0]).intValue();
        Long TotalService = ((Number) result[1]).longValue();

        Map<String, Object> Fresult= new HashMap<>();
        Fresult.put("Total Service", TotalService);
        Fresult.put("Total Earnings", TotalEarnings);
        return ResponseEntity.ok(Fresult);
    }
}
