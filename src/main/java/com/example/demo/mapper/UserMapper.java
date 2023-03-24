package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
    List<User> getUsers();
    User getUserById(Long id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}