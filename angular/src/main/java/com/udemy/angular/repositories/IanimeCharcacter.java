package com.udemy.angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.angular.entities.AnimeCharacter;

public interface IanimeCharcacter extends JpaRepository<AnimeCharacter, Long> {

}
