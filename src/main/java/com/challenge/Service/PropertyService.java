package com.challenge.Service;

import com.challenge.Entity.RentalEntity;
import com.challenge.Exception.PropertyException;
import com.challenge.Resource.Input.AvailablePropertyInput;
import com.challenge.Respository.RentalRepository;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PropertyService {

    @Inject
    RentalRepository rentalRepository;

    public String searchProperty(AvailablePropertyInput input) throws BadRequestException {
        if (input.getEndDate().isBefore(input.getStartDate())) {
            throw new PropertyException("endDate must be greater than startDate");
        }
        return checkAvailability(input.getPropertyId(), input.getStartDate(), input.getEndDate()) == Boolean.TRUE ? "true" : "false";
    }

    public boolean checkAvailability(Long propertyId, LocalDate startDate, LocalDate endDate) {
        Log.info("Checking availability");
        for (RentalEntity rentals : getNextRentals(propertyId, startDate)) {
            var validateStart = !((startDate.isAfter(rentals.startDate) || startDate.equals(rentals.startDate))
                    && (startDate.isBefore(rentals.endDate) || startDate.equals(rentals.endDate)));
            var validateEnd = !((endDate.isAfter(rentals.startDate) || endDate.equals(rentals.startDate))
                    && (endDate.isBefore(rentals.endDate) || endDate.equals(rentals.endDate)));
            var validateAround = !(startDate.isBefore(rentals.startDate) && endDate.isAfter(rentals.endDate));
            if (!(validateStart && validateEnd && validateAround)) {
                Log.info("Not available for propertyId=".concat(String.valueOf(propertyId)));
                return Boolean.FALSE;
            }
        }
        Log.info("Available for propertyId=".concat(String.valueOf(propertyId)));
        return Boolean.TRUE;
    }

    private List<RentalEntity> getNextRentals(Long id, LocalDate startDate) {
        //Search for the next scheduled rentals
        //rentalRepository.listNextRentals(id, startDate);

        //Mocking 2 example rentals
        RentalEntity rental1 = RentalEntity.builder()
                .id(Long.valueOf(1))
                .propertyId(1L)
                .startDate(LocalDate.of(2022, 12, 20))
                .endDate(LocalDate.of(2022, 12, 25)).build();
        RentalEntity rental2 = RentalEntity.builder()
                .id(2L)
                .propertyId(2L)
                .startDate(LocalDate.of(2023, 1, 10))
                .endDate(LocalDate.of(2023, 1, 20)).build();

        List<RentalEntity> list = new ArrayList<>();
        list.add(rental1);
        list.add(rental2);
        Log.info("Next rentals list=".concat(String.valueOf(list)));
        return list;
    }
}
