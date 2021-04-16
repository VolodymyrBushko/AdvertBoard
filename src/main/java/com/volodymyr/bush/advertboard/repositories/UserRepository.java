package com.volodymyr.bush.advertboard.repositories;

import com.volodymyr.bush.advertboard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
