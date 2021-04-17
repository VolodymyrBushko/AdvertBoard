package com.volodymyr.bush.advertboard.services;

import com.volodymyr.bush.advertboard.entities.Advert;
import com.volodymyr.bush.advertboard.entities.User;
import com.volodymyr.bush.advertboard.exceptions.NotFoundException;
import com.volodymyr.bush.advertboard.repositories.AdvertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final UserService userService;

    public AdvertServiceImpl(AdvertRepository advertRepository, UserService userService) {
        this.advertRepository = advertRepository;
        this.userService = userService;
    }

    @Override
    public List<Advert> getAll() {
        return advertRepository.findAll();
    }

    @Override
    public Advert getById(Long id) {
        return advertRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find advert with id: " + id));
    }

    @Override
    public Advert create(Advert advert) {
        User user = userService.getById(advert.getUserId());
        user.setAdverts(Set.of(advert));
        return advertRepository.save(advert);
    }

    @Override
    public Advert update(Advert newAdvert, Long id) {
        return advertRepository.findById(id)
                .map(advert -> {
                    advert.setCategory(newAdvert.getCategory());
                    advert.setText(newAdvert.getText());
                    advert.setContacts(newAdvert.getContacts());
                    advert.setStartDate(newAdvert.getStartDate());
                    advert.setDuration(newAdvert.getDuration());
                    advert.setUser(null);

                    User user = userService.getById(newAdvert.getUserId());
                    user.setAdverts(Set.of(advert));

                    advertRepository.save(advert);
                    return advert;
                })
                .orElseThrow(() -> new NotFoundException("Could not find advert with id: " + id));
    }

    @Override
    public void remove(Long id) {
        advertRepository.deleteById(id);
    }
}
