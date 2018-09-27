package com.example.webpractice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer>{

	List<User> findByName(String name);

}
