package com.company.server_assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.server_assignment.entities.User;


public interface UserRepo extends JpaRepository<User, Integer>{

}

