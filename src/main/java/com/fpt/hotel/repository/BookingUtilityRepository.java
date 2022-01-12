package com.fpt.hotel.repository;

import com.fpt.hotel.model.BookingUtility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUtilityRepository extends JpaRepository<BookingUtility , Long> {
}
