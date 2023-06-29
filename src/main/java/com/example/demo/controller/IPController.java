package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rest.MyController;

@RestController
@RequestMapping("/api/ip")
public class IPController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
    @GetMapping
    public String getDeviceList(HttpServletRequest httpServletRequest) {
    	
    	String ip = httpServletRequest.getRemoteHost();
    	logger.trace( ip );
		return httpServletRequest.getRemoteHost();
    }
}
