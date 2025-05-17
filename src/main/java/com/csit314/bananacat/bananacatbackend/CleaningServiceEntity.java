package com.csit314.bananacat.bananacatbackend;
import java.util.Optional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="cleaningservice")
public class CleaningServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this will allow id to be ignored by requestbody, in short json dont need to send id
    private Long id; //most likely wont be usin this pk at all, only reason im using id as pk is cause composite pk(email and name) is a pain in the ass to set up
    private String email;
    private String serviceName;
    private String tag;
    private BigDecimal price;
    private String location;
    private Integer NumberOfView; //for User story #15, rmb to update db make it default 0, cannot be null after cleaning service creation cause of nullpointerexception

    public Long getId() {
        return id;
    }
    public String getServiceName() {
    return serviceName;
    }
    
    public String getTag() {
        return tag;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getLocation() {
        return location;
    }
    public Integer getNumberOfView() {
        return NumberOfView;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public void setDefaultNumberofView(){
        this.NumberOfView = 0;
    }

    public String getEmail() {
    return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean CreateCleaningService(CleaningServiceRepository CSRepository) {
        
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailAndServiceName(this.email, this.serviceName);
        if (CSoptional.isPresent()) {
            return false;
        }
        this.setDefaultNumberofView();
        CSRepository.save(this);
        return true;
    }

    //for viewing specific service, this method is for homeowner
    public ResponseEntity<?> ViewCleaningServiceforHomeOwner(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailAndServiceName(this.email, this.serviceName);

        if (!(CSoptional.isPresent())) {
            return ResponseEntity.ok("not found");
        } else {
            CleaningServiceEntity result = CSoptional.get();
            result.IncreaseNumberOfViews();
            CSRepository.save(result);
            return ResponseEntity.ok(CSoptional.get());
        }
    }

    //for viewing list of service, thie method for both homeowner and cleaner, but dont display view for homeowner
    public ResponseEntity<?> ViewCleaningServiceList() {
        CleaningServiceRepository CSRepository = CleaningServiceRepositoryInjector.repo;
        List<CleaningServiceEntity> result = CSRepository.findByEmail(this.email);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> ViewCleaningServiceforCleaner() {
        CleaningServiceRepository CSRepository = CleaningServiceRepositoryInjector.repo;
        Optional<CleaningServiceEntity> result = CSRepository.findByEmailAndServiceName(this.email, this.serviceName);
        if (!(result.isPresent())) {
            return ResponseEntity.ok("not found");
        } else {
            return ResponseEntity.ok(result.get());
        }
    }

    @Transactional
    public ResponseEntity<?> UpdateCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findById(this.id);
        if (CSoptional.isPresent()) {
            CleaningServiceEntity org = CSoptional.get();
            
            org.setServiceName(this.serviceName);
        
            org.setTag(this.tag);
        
            org.setPrice(this.price);
        
            org.setLocation(this.location);
            
            CSRepository.save(org);
            return ResponseEntity.ok(org);
        } else {
            return ResponseEntity.ok("not found");
        }
    }
    @Transactional
    public boolean DeleteCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailAndServiceName(this.email, this.serviceName);
        if (CSoptional.isPresent()) {
            CleaningServiceEntity CS = CSoptional.get();
            CSRepository.deleteById(CS.getId());
            return true;
        } else {
            return false;
        }
    }
    public ResponseEntity<?> SearchCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailAndServiceName(this.email, this.serviceName);
        if(CSoptional.isPresent()) {
            return ResponseEntity.ok(CSoptional.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }

    // Method to increase the number of views
    public void IncreaseNumberOfViews() {
        if (this.NumberOfView == null) {
            this.NumberOfView = 1;
        } else {
            this.NumberOfView += 1;
        }
    }
}