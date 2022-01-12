package com.fpt.hotel.repository;

import com.fpt.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM `bookings` WHERE id_user = ?1 and status = \"Đang sử dụng\"" , nativeQuery = true)
    List<Booking> findById_user (Long id);

    @Query(value = "SELECT * FROM `bookings` WHERE id_user = ?1 and status = \"Đã đặt cọc\" and id_hotel = ?2 " , nativeQuery = true)
    List<Booking> listBookingByIdUser(Long id , Long id_hotel);
}
