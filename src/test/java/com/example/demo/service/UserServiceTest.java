package com.example.demo.service;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.MData;
import com.example.demo.model.User;
import com.example.demo.rest.MyController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class UserServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
    private UserService userService;
	
	@Autowired
	protected ObjectMapper						objectMapper;
	
	@Test
    public void testGetAllUsers() throws JsonProcessingException {
		List<User> users = userService.getAllUsers();
		assertNotNull(users);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(users);
		
		logger.info("\033[32m" + jsonString + "\033[0m");
		
    }
	
	@Test
	public void testObjectMapper() throws JsonProcessingException {
		
		Object map = null;
		MData a;
		
		if(map == null) {
			a = new MData();
		}
		
		a = objectMapper.convertValue(map, MData.class);
		
		assertNotNull(a);
		
	}
}
