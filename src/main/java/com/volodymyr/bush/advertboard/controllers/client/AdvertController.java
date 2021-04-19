package com.volodymyr.bush.advertboard.controllers.client;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.services.client.AdvertServiceClientImpl;
import com.volodymyr.bush.advertboard.services.client.UserServiceClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adverts/")
public class AdvertController {

    private final AdvertServiceClientImpl advertService;
    private final UserServiceClientImpl userService;

    public AdvertController(AdvertServiceClientImpl advertService, UserServiceClientImpl userService) {
        this.advertService = advertService;
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("adverts", advertService.getAll());
        return "advert/index";
    }

    @GetMapping("{id}")
    public String info(@PathVariable Long id, Model model) {
        model.addAttribute("advert", advertService.getById(id));
        model.addAttribute("users", userService.getAll());
        return "advert/info";
    }

    @GetMapping("create")
    public String createAdvertPage(Model model) {
        model.addAttribute("advert", new Advert());
        model.addAttribute("users", userService.getAll());
        return "advert/create";
    }

    @PostMapping
    public String createAdvert(@ModelAttribute Advert advert) {
        advertService.create(advert);
        return "redirect:/adverts/";
    }

    @PutMapping("{id}")
    public String updateAdvert(@ModelAttribute Advert advert, @PathVariable Long id) {
        advertService.update(advert, id);
        return "redirect:/adverts/";
    }

    @GetMapping("delete/{id}")
    public String deleteAdvert(@PathVariable Long id) {
        advertService.remove(id);
        return "redirect:/adverts/";
    }
}
