package com.first.helloworld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.User;

import java.util.*;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String username);
	List<User> findByUsernameContainingIgnoreCase(String username);
}
