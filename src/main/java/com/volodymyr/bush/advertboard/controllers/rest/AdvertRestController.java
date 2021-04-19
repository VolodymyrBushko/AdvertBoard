package com.volodymyr.bush.advertboard.controllers.rest;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.services.interfaces.AdvertService;
import com.volodymyr.bush.advertboard.services.rest.AdvertServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data/adverts/")
public class AdvertRestController {

    private final AdvertServiceImpl service;

    public AdvertRestController(AdvertServiceImpl service) {
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
