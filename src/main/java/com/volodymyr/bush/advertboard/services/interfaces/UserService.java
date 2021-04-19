package com.volodymyr.bush.advertboard.services.interfaces;

import com.volodymyr.bush.advertboard.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User create(User user);

    User update(User newUser, Long id);

    void remove(Long id);
}
