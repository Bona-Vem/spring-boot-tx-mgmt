package com.example.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.rest.MyController;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	
    @Autowired
    private UserService userService;
    
    @Value("${server.prop}")
    private String prop;

    @GetMapping
    public List<User> getAllUsers() {
    	System.out.println("\033[32m" + prop + "\033[0m");
    	logger.info("Hello from Spring Boot!");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    

    @PostMapping("/addUser1")
    public void addUser1(@RequestBody User user) throws Exception {
        userService.addUser1(user);
    }
    

    @PostMapping("/addUser2")
    public void addUser2(@RequestBody User user) throws Exception {
        userService.addUser2(user);
    }
    
    @PostMapping("/addUser3")
    public void addUser3(@RequestBody User user) throws Exception {
    	userService.addUser3(user);
    }
}
