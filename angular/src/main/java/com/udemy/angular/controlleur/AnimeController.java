package com.udemy.angular.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.angular.entities.AnimeCharacter;
import com.udemy.angular.repositories.IanimeCharcacter;

@RestController
@RequestMapping("/v1/anime")
public class AnimeController {

	private IanimeCharcacter animeRepository;
	
	/*rechercher d'un anime */
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(animeRepository.findAll());	
	}
	
	/*rechercher anime avec id*/
	public ResponseEntity findAnimeById(@PathVariable(name="idAnime") Long idAnime) {
		if(idAnime == null) {
			return ResponseEntity.badRequest().body("cannot find anime avec id null");
		}
		AnimeCharacter anime= animeRepository.getOne(idAnime);
		if(anime == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(anime);
	}
}
