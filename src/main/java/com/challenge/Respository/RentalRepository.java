package com.challenge.Respository;

import com.challenge.Entity.RentalEntity;
//import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RentalRepository { //implements PanacheRepository<RentalEntity> {
    public List<RentalEntity> listNextRentals(Long propertyId, LocalDate startDate){
//        return list("propertyId = ?1 and endDate > ?2", propertyId, startDate);
        return new ArrayList<>();
    }
}