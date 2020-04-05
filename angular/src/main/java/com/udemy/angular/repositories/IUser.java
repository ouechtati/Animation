package com.udemy.angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.angular.entities.User;

public interface IUser extends JpaRepository<User, Long> {

}
