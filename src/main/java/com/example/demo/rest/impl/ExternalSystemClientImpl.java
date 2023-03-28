package com.example.demo.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.rest.ExternalSystemClient;

@Component
public class ExternalSystemClientImpl implements ExternalSystemClient {

    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${custom.baseurl}")
    private String baseurl;

    public String getData(String param) {
        // Make a GET request to the external system's API endpoint
        String url = baseurl + param;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Return the response body
        return response.getBody();
    }
}
