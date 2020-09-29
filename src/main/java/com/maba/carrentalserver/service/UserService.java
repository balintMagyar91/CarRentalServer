package com.maba.carrentalserver.service;

import com.maba.carrentalserver.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findAllByRole(String role);
    void save(User user);
}
