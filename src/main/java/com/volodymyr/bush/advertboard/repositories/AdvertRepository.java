package com.volodymyr.bush.advertboard.repositories;

import com.volodymyr.bush.advertboard.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
