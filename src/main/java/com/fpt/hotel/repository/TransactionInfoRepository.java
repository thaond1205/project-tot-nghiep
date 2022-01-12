package com.fpt.hotel.repository;

import com.fpt.hotel.model.Transaction_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TransactionInfoRepository extends JpaRepository<Transaction_Info , Long> {

    @Query(value = "SELECT * FROM `transaction_infos` WHERE id_booking = ?1" , nativeQuery = true)
    Transaction_Info findByIdBooking(Long idBooking);
}
