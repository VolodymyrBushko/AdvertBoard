package com.volodymyr.bush.advertboard.controllers.client;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.services.client.AdvertServiceClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adverts/")
public class AdvertController {

    private final AdvertServiceClientImpl service;

    public AdvertController(AdvertServiceClientImpl service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("adverts", service.getAll());
        return "advert/index";
    }

    @GetMapping("{id}")
    public String info(@PathVariable Long id, Model model) {
        model.addAttribute("advert", service.getById(id));
        return "advert/info";
    }

    @GetMapping("create")
    public String createAdvertPage(Model model) {
        model.addAttribute("advert", new Advert());
        return "advert/create";
    }

    @PostMapping
    public String createAdvert(@ModelAttribute Advert advert) {
        service.create(advert);
        return "redirect:/adverts/";
    }

    @PutMapping("{id}")
    public String updateAdvert(@ModelAttribute Advert advert, @PathVariable Long id) {
        service.update(advert, id);
        return "redirect:/adverts/";
    }

    @GetMapping("delete/{id}")
    public String deleteAdvert(@PathVariable Long id) {
        service.remove(id);
        return "redirect:/adverts/";
    }
}
