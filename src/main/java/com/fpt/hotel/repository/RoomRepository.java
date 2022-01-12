package com.fpt.hotel.repository;

import com.fpt.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Boolean existsByNumberRoom(String numberRoom);

    @Query(value = "SELECT * FROM `rooms` join hotels on hotels.id = rooms.id_hotel where id_hotel = ?1" , nativeQuery = true)
    List<Room> findAll(Long id );

}
