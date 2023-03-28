package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final ExternalSystemClient externalSystemClient;

    public MyController(ExternalSystemClient externalSystemClient) {
        this.externalSystemClient = externalSystemClient;
    }

    @GetMapping("/data")
    public String getData(@RequestParam("param") String param) {
        // Call the external system's API to get data
        String data = externalSystemClient.getData(param);

        // Process the data and return a response
        return data;
    }
}
