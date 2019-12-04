package com.blazejknie.myprojects.computer_shop.controller;

import com.blazejknie.myprojects.computer_shop.model.User;
import com.blazejknie.myprojects.computer_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("user")
    public User getUser(@RequestParam Long id) {
        return userRepository.findById(id).orElseThrow(()->new NoSuchElementException(String.format("element o id = %d nie istnieje",id)));
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
