package com.first.helloworld.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{
    Admin findByUsername(String adminName);
}

