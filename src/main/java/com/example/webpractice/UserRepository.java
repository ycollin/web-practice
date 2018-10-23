package com.example.webpractice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User> {

	List<User> findByName(String name);

}
