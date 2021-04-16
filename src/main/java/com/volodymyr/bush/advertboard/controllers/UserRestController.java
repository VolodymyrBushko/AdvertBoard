package com.volodymyr.bush.advertboard.controllers;

import com.volodymyr.bush.advertboard.entities.User;
import com.volodymyr.bush.advertboard.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> allUsers() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public User oneUser(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return service.update(user, id);
    }

    @DeleteMapping("{id}")
    public void removeUser(@PathVariable Long id) {
        service.remove(id);
    }
}
