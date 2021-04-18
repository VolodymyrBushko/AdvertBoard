package com.volodymyr.bush.advertboard.controllers;

import com.volodymyr.bush.advertboard.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/users/")
public class UserController {

    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/data/users/";

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String index(Model model) {
        User[] users = restTemplate.getForObject(URL, User[].class);
        if (users != null) {
            model.addAttribute("users", users);
            return "user/index";
        }
        throw new RuntimeException("Error: index (GET)");
    }
}
