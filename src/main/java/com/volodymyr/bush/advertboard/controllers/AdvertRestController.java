package com.volodymyr.bush.advertboard.controllers;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.services.AdvertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/adverts/")
public class AdvertRestController {

    private final AdvertService service;

    public AdvertRestController(AdvertService service) {
        this.service = service;
    }

    @GetMapping
    public List<Advert> allAdverts() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Advert oneAdvert(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Advert createAdvert(@RequestBody Advert advert) {
        return service.create(advert);
    }

    @PutMapping("{id}")
    public Advert updateAdvert(@RequestBody Advert advert, @PathVariable Long id) {
        return service.update(advert, id);
    }

    @DeleteMapping("{id}")
    public void removeAdvert(@PathVariable Long id) {
        service.remove(id);
    }
}
