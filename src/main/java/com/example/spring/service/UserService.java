package com.example.spring.service;


import com.example.spring.model.User;

import java.util.List;

public interface UserService {
    List<User> showAllUsers();
    User show(Integer id);
    void save(User user);
    void update(Integer id, User user);
    void delete(Integer id);
}
