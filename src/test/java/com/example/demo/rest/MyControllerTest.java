package com.example.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerTest {

	@Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetData() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/data?param=1", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.err.println(">>>>>>>>>>>>>>>>>> " + response);
    }
}