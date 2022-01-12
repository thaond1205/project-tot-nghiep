package com.fpt.hotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpt.hotel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value = "SELECT * FROM `users` join user_roles on user_roles.user_id = users.id join roles on roles.id = user_roles.role_id \r\n"
			+ "where roles.name = ?1", nativeQuery = true)
	List<User> findAll(String roleName);

}
