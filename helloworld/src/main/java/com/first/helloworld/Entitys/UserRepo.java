package com.first.helloworld.Entitys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String username);
	List<User> findByUsernameContainingIgnoreCase(String username);
}
