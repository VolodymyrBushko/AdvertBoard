package com.volodymyr.bush.advertboard.services;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.exceptions.NotFoundException;
import com.volodymyr.bush.advertboard.repositories.AdvertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository repository;

    public AdvertServiceImpl(AdvertRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Advert> getAll() {
        return repository.findAll();
    }

    @Override
    public Advert getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find advert with id: " + id));
    }

    @Override
    public Advert create(Advert advert) {
        return repository.save(advert);
    }

    @Override
    public Advert update(Advert newAdvert, Long id) {
        return repository.findById(id)
                .map(advert -> {
                    advert.setCategory(newAdvert.getCategory());
                    advert.setText(newAdvert.getText());
                    advert.setContacts(newAdvert.getContacts());
                    advert.setStartDate(newAdvert.getStartDate());
                    advert.setDuration(newAdvert.getDuration());

                    repository.save(advert);
                    return advert;
                })
                .orElseThrow(() -> new NotFoundException("Could not find advert with id: " + id));
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
