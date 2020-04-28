package com.example.demo.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.api.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
