package com.maba.carrentalserver.controller;

import com.maba.carrentalserver.entity.User;
import com.maba.carrentalserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/listUsers")
    public List<User> findUsers() {
        return userService.findAllByRole("USER");
    }

    @GetMapping("/listAdmins")
    public List<User> findAdmins() {
        return userService.findAllByRole("ADMIN");
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
