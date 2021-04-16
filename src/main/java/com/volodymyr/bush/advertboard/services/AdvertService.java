package com.volodymyr.bush.advertboard.services;

import com.volodymyr.bush.advertboard.entities.Advert;

import java.util.List;

public interface AdvertService {

    List<Advert> getAll();

    Advert getById(Long id);

    Advert create(Advert advert);

    Advert update(Advert newAdvert, Long id);

    void remove(Long id);
}
