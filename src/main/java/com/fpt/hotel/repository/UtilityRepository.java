package com.fpt.hotel.repository;

import com.fpt.hotel.model.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends JpaRepository<Utility , Long> {
}
