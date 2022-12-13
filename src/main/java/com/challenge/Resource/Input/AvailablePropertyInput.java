package com.challenge.Resource.Input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AvailablePropertyInput {
    @Positive(message = "propertyId must be a positive number")
    long propertyId;
    @FutureOrPresent(message = "startDate must be in the future")
    LocalDate startDate;
    @FutureOrPresent(message = "endDate must be in the future")
    LocalDate endDate;

}
