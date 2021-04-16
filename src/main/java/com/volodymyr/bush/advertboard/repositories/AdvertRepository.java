package com.volodymyr.bush.advertboard.repositories;

import com.volodymyr.bush.advertboard.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
