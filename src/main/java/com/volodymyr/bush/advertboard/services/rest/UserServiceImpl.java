package com.volodymyr.bush.advertboard.services.rest;

import com.volodymyr.bush.advertboard.entities.User;
import com.volodymyr.bush.advertboard.exceptions.NotFoundException;
import com.volodymyr.bush.advertboard.repositories.UserRepository;
import com.volodymyr.bush.advertboard.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + id));
    }

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User newUser, Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setSurname(newUser.getSurname());
                    user.setPhone(newUser.getPhone());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setAdverts(newUser.getAdverts());

                    repository.save(user);
                    return user;
                })
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + id));
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
