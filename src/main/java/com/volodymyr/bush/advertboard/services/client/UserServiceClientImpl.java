package com.volodymyr.bush.advertboard.services.client;

import com.volodymyr.bush.advertboard.entities.User;
import com.volodymyr.bush.advertboard.services.interfaces.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceClientImpl implements UserService {

    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/data/users/";

    public UserServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getAll() {
        User[] users = restTemplate.getForObject(URL, User[].class);
        return users != null ? Arrays.asList(users.clone()) : null;
    }

    @Override
    public User getById(Long id) {
        return restTemplate.getForObject(URL + id, User.class);
    }

    @Override
    public User create(User user) {
        HttpEntity<User> request = new HttpEntity<>(user);
        return restTemplate.postForObject(URL, request, User.class);
    }

    @Override
    public User update(User newUser, Long id) {
        HttpEntity<User> request = new HttpEntity<>(newUser);
        restTemplate.exchange(URL + id, HttpMethod.PUT, request, Void.class);
        return newUser;
    }

    @Override
    public void remove(Long id) {
        restTemplate.delete(URL + id);
    }
}
