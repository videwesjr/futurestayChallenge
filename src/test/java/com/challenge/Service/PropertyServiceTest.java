package com.challenge.Service;

import com.challenge.Exception.PropertyException;
import com.challenge.Resource.Input.AvailablePropertyInput;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.inject.Inject;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class PropertyServiceTest {
    @Inject
    public PropertyService service;

    @Test
    public void searchPropertyTrueTest() {
        AvailablePropertyInput input = new AvailablePropertyInput(1,
                LocalDate.of(2022, 12, 10),
                LocalDate.of(2022, 12, 15));
        assertEquals(service.searchProperty(input), "true");
    }

    @Test
    public void searchPropertyFalseTest() {
        AvailablePropertyInput input = new AvailablePropertyInput(1,
                LocalDate.of(2022, 12, 21),
                LocalDate.of(2022, 12, 22));
        assertEquals(service.searchProperty(input), "false");
    }
    @Test
    public void searchPropertyDateValidationException() {
        AvailablePropertyInput input = new AvailablePropertyInput(1,
                LocalDate.of(2022, 12, 21),
                LocalDate.of(2022, 12, 20));
        assertThrows(PropertyException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                assertEquals(service.searchProperty(input), "false");
            }
        });
    }
}
