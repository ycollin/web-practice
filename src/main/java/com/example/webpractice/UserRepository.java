package com.example.webpractice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByName(String name);
	List<User> findByNameLike(String name);

}
