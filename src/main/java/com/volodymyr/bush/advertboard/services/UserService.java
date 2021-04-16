package com.volodymyr.bush.advertboard.services;

import com.volodymyr.bush.advertboard.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User create(User entity);

    User update(User entity, Long id);

    User remove(Long id);
}
