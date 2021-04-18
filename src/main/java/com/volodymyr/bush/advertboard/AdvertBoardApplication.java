package com.volodymyr.bush.advertboard;

import com.volodymyr.bush.advertboard.entities.Advert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class AdvertBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertBoardApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
        return args -> {
            String url = "http://localhost:8080/api/data/users/";

            // https://www.baeldung.com/rest-template

            // Get all users
            // User[] users = restTemplate.getForObject(url, User[].class);

            // Advert[] adverts = restTemplate.getForObject("http://localhost:8080/api/data/adverts/", Advert[].class);
            // System.out.println(Arrays.toString(adverts));

            // Create a new user (1)
            // HttpEntity<User> request = new HttpEntity<>(
            //         new User("test1", "test1", "123", "test1@gmail.com", "123")
            // );
            // User response = restTemplate.postForObject(url, request, User.class);
            // System.out.println(response);

            // Create a new User (2)
            // HttpEntity<User> request = new HttpEntity<>(
            //         new User("test", "test", "123", "test@gmail.com", "123")
            // );
            // ResponseEntity<User> response =
            //         restTemplate.exchange(url, HttpMethod.POST, request, User.class);
            // if (response.getStatusCode().equals(HttpStatus.OK)) {
            //     System.out.println(response.getBody());
            // }

            // Update a user (without response body)
            // HttpEntity<User> request = new HttpEntity<>(
            //         new User("updated", "test1", "123", "test1@gmail.com", "123")
            // );
            // restTemplate.exchange(url + "129", HttpMethod.PUT, request, Void.class);

            // Delete a user
            // restTemplate.delete(url + "129");
        };
    }
}
