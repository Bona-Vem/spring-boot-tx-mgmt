package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.MyException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {
    @Autowired
    private UserMapper myMapper;

    public List<User> getAllUsers() {
        return myMapper.getUsers();
    }

    public User getUserById(Long id) {
        return myMapper.getUserById(id);
    }

    @Transactional
    public void addUser(User user) {
        myMapper.insertUser(user);
    }
    
    public void addUser1(User user) throws Exception {
    	myMapper.insertUser(user);
    	throw new RuntimeException("Insert even an error occurs");
    }
    
    @Transactional
    public void addUser2(User user) throws Exception {
    	myMapper.insertUser(user);
    	throw new RuntimeException("Rollback inserted record!");
    }
    
    @Transactional
    public void addUser3(User user) throws Exception {
    	myMapper.insertUser(user);
    	throw new MyException("Rollback inserted record!");
    }
    
    

    @Transactional
    public void updateUser(Long id, User user) {
        User existingUser = myMapper.getUserById(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            myMapper.updateUser(existingUser);
        }
    }

    @Transactional
    public void deleteUser(Long id) {
        myMapper.deleteUser(id);
    }
}