package com.example.demo.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;

@SpringBootTest
public class UserServiceTest {
	
	
	@Autowired
    private UserService userService;
	
	
	@Test
    public void testGetAllUsers() {

		List<User> users = userService.getAllUsers();
		assertNotNull(users);
		System.err.println(">>>>>>>>>>>>>>>>>>" + users);
		
    }
}
