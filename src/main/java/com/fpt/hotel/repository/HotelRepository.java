package com.fpt.hotel.repository;

import com.fpt.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Boolean existsByName(String name);
}
