package com.volodymyr.bush.advertboard.services;

import com.volodymyr.bush.advertboard.entities.Advert;

import java.util.List;

public interface AdvertService {

    List<Advert> getAll();

    Advert getById(Long id);

    Advert create(Advert entity);

    Advert update(Advert entity, Long id);

    Advert remove(Long id);
}
