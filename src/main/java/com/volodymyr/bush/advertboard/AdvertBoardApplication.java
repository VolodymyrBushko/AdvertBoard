package com.volodymyr.bush.advertboard;

import com.volodymyr.bush.advertboard.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvertBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertBoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserServiceImpl service) {
        return args -> {
            service.getAll();
        };
    }

}
