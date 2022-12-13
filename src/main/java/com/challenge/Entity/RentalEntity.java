package com.challenge.Entity;

//import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
//@Entity
public class RentalEntity {//extends PanacheEntity {
    public Long id;
    public Long propertyId;
    public LocalDate startDate;
    public LocalDate endDate;
}

