package com.volodymyr.bush.advertboard.services.client;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.entities.User;
import com.volodymyr.bush.advertboard.services.interfaces.AdvertService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AdvertServiceClientImpl implements AdvertService {

    private final RestTemplate restTemplate;
    private final UserServiceClientImpl userService;
    private final String URL = "http://localhost:8080/api/data/adverts/";

    public AdvertServiceClientImpl(RestTemplate restTemplate, UserServiceClientImpl userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    @Override
    public List<Advert> getAll() {
        Advert[] adverts = restTemplate.getForObject(URL, Advert[].class);
        return adverts != null ? Arrays.asList(adverts.clone()) : null;
    }

    @Override
    public Advert getById(Long id) {
        return restTemplate.getForObject(URL + id, Advert.class);
    }

    @Override
    public Advert create(Advert advert) {
        HttpEntity<Advert> request = new HttpEntity<>(advert);
        return restTemplate.postForObject(URL, request, Advert.class);
    }

    @Override
    public Advert update(Advert newAdvert, Long id) {
        HttpEntity<Advert> request = new HttpEntity<>(newAdvert);
        restTemplate.exchange(URL + id, HttpMethod.PUT, request, Void.class);
        return newAdvert;
    }

    @Override
    public void remove(Long id) {
        Advert advert = getById(id);
        if (advert != null) {
            User user = userService.getById(advert.getUser().getId());
            user.getAdverts().removeIf(e -> e.getId().equals(advert.getId()));
            advert.setUser(null);
            userService.update(user, user.getId());
            restTemplate.delete(URL + id);
        }
    }
}
