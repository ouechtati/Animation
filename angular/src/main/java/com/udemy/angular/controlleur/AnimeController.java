package com.udemy.angular.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.angular.repositories.IanimeCharcacter;

@RestController
@RequestMapping("/v1/anime")
public class AnimeController {

	private IanimeCharcacter animeRepository;
	
	/*récupération d'un user */
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(animeRepository.findAll());	
	}
}
