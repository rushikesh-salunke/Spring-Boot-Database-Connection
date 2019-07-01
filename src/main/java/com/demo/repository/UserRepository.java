package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Object findByIdAndName(Integer id, String string);

	Optional<User> findById(Integer parseInt);
	
}
