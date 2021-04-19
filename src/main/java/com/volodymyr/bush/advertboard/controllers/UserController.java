package com.volodymyr.bush.advertboard.controllers;

import com.volodymyr.bush.advertboard.entities.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("{id}")
    public String info(@PathVariable Long id, Model model) {
        String url = String.format("%s%d", URL, id);
        User user = restTemplate.getForObject(url, User.class);
        if (user != null) {
            model.addAttribute("user", user);
            return "user/info";
        }
        throw new RuntimeException("Error: info (GET)");
    }

    @PutMapping("{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable Long id) {
        String url = String.format("%s%d", URL, id);
        HttpEntity<User> request = new HttpEntity<>(user);
        restTemplate.exchange(url, HttpMethod.PUT, request, Void.class);
        return "redirect:/users/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        String url = String.format("%s%d", URL, id);
        restTemplate.delete(url);
        return "redirect:/users/";
    }
}
