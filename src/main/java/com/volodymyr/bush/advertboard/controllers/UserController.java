package com.volodymyr.bush.advertboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/")
public class UserController {

    private final String URL = "http://localhost:8080/api/data/adverts";

    @GetMapping
    public String index() {
        return "user/index";
    }
}
