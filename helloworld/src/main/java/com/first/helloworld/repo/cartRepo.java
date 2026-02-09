package com.first.helloworld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Cart;

@Repository
public interface cartRepo extends JpaRepository<Cart, Long> {

}