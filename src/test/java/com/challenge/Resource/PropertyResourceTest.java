package com.challenge.Resource;

import com.challenge.Resource.Input.AvailablePropertyInput;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PropertyResourceTest {

    @Test
    public void testAvailablePropertyEndpoint() {
        AvailablePropertyInput input = new AvailablePropertyInput(1,
                LocalDate.of(2025, 12, 01),
                LocalDate.of(2025, 12, 22));

        given()
                .when()
                .contentType("application/json")
                .body(input)
                .post("/property/available")
                .then()
                .statusCode(200)
                .body(is("true"));
    }
}