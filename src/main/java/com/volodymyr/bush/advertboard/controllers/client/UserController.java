package com.volodymyr.bush.advertboard.controllers.client;

import com.volodymyr.bush.advertboard.entities.User;
import com.volodymyr.bush.advertboard.services.client.UserServiceClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/")
public class UserController {

    private final UserServiceClientImpl service;

    public UserController(UserServiceClientImpl service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", service.getAll());
        return "user/index";
    }

    @GetMapping("{id}")
    public String info(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "user/info";
    }

    @GetMapping("create")
    public String createUserPage(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        service.create(user);
        return "redirect:/users/";
    }

    @PutMapping("{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable Long id) {
        service.update(user, id);
        return "redirect:/users/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.remove(id);
        return "redirect:/users/";
    }
}
