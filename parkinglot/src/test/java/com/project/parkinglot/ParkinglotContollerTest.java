package com.project.parkinglot;

import com.project.parkinglot.controller.parkinglot.ParkinglotRequest;
import com.project.parkinglot.controller.parkinglot.ParkinglotResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkinglotContollerTest extends BaseIntegrationTest {


    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_parkinglot() {

        //given
        ParkinglotRequest parkinglotRequest = new ParkinglotRequest();
        parkinglotRequest.setParkinglotName("parkinglotName");
        parkinglotRequest.setCity("city");
        parkinglotRequest.setTotalCapacity(4);

        //when
        ResponseEntity<ParkinglotResponse> response = testRestTemplate.postForEntity("/parkinglots", parkinglotRequest, ParkinglotResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat((response.getBody().getCity())).isEqualTo("city");
        assertThat(response.getBody().getParkinglotName()).isEqualTo("parkinglotName");
        assertThat(response.getBody().getCurrentCapacity()).isEqualTo(4);
        assertThat(response.getBody().getTotalAmount()).isEqualTo(0);
        assertThat(response.getBody().getCurrentCapacity()).isEqualTo(4);
    }

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_retrieve_parkinglot() {

        //Given
        ParkinglotRequest parkinglotRequest = new ParkinglotRequest();
        parkinglotRequest.setParkinglotName("parkinglotName2");
        parkinglotRequest.setCity("city2");
        parkinglotRequest.setTotalCapacity(5);


        //When
        ResponseEntity<ParkinglotResponse> createResponse = testRestTemplate.postForEntity("/parkinglots", parkinglotRequest, ParkinglotResponse.class);
        ResponseEntity<ParkinglotResponse> resultResponse = testRestTemplate.getForEntity("/parkinglots/2", ParkinglotResponse.class);


        //Then
        assertThat(resultResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultResponse.getBody()).isNotNull();
        assertThat(resultResponse.getBody().getCity()).isEqualTo("city2");
        assertThat(resultResponse.getBody().getParkinglotName()).isEqualTo("parkinglotName2");
        assertThat(resultResponse.getBody().getTotalAmount()).isEqualTo(0);
        assertThat(resultResponse.getBody().getCurrentCapacity()).isEqualTo(5);


    }

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_delete_parkinglot() {

        //Given
        ParkinglotRequest parkinglotRequest = new ParkinglotRequest();
        parkinglotRequest.setParkinglotName("parkinglotName3");
        parkinglotRequest.setTotalCapacity(6);
        parkinglotRequest.setCity("city3");

        //When
        ResponseEntity<ParkinglotResponse> createResponse = testRestTemplate.postForEntity("/parkinglots", parkinglotRequest, ParkinglotResponse.class);
        testRestTemplate.delete("/parkinglots/3");
        ResponseEntity<ParkinglotResponse> resultResponse = testRestTemplate.getForEntity("/parkinglots/3", null);

        //Then
        assertThat(resultResponse.getBody()).isNull();

    }

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_update_parkinglot() {

        //Given
        ParkinglotRequest parkinglotRequest = new ParkinglotRequest();
        parkinglotRequest.setParkinglotName("parkinglotName");
        parkinglotRequest.setCity("city");
        parkinglotRequest.setTotalCapacity(2);

        ParkinglotRequest updatedParkinglotRequest = new ParkinglotRequest();
        updatedParkinglotRequest.setParkinglotName("updatedParkinglotName");
        updatedParkinglotRequest.setCity("updatedCity");
        updatedParkinglotRequest.setTotalCapacity(3);

        //When
        ResponseEntity<ParkinglotResponse> createResponse = testRestTemplate.postForEntity("/parkinglots", parkinglotRequest, ParkinglotResponse.class);
        testRestTemplate.put("/parkinglots/3", updatedParkinglotRequest);
        ResponseEntity<ParkinglotResponse> resultResponse = testRestTemplate.getForEntity("/parkinglots/3", ParkinglotResponse.class);

        //Then
        assertThat(resultResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(resultResponse.getBody().getParkinglotName()).isEqualTo("updatedParkinglotName");
        assertThat((resultResponse.getBody().getTotalAmount())).isEqualTo(0);
        assertThat(resultResponse.getBody().getCity()).isEqualTo("updatedCity");
        assertThat(resultResponse.getBody().getTotalCapacity()).isEqualTo(3);
        assertThat(resultResponse.getBody().getCurrentCapacity()).isEqualTo(3);

    }
}
