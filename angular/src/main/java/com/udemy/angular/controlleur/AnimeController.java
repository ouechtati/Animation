package com.udemy.angular.controlleur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.angular.entities.AnimeCharacter;
import com.udemy.angular.repositories.IanimeCharcacter;

@RestController
@RequestMapping("/v1/anime")
public class AnimeController {

	private IanimeCharcacter charcterRepository;
	
	/*rechercher d'un anime */
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(charcterRepository.findAll());	
	}
	
	/*rechercher anime avec id*/
	@GetMapping ("/{idAnime}")
	public ResponseEntity findCharcterById(@PathVariable(name="idAnime") Long idAnime) {
		if(idAnime == null) {
			return ResponseEntity.badRequest().body("cannot find anime avec id null");
		}
		AnimeCharacter character= charcterRepository.getOne(idAnime);
		if(character == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(character);
	}
	@PostMapping("/")
	public ResponseEntity createCharcter (@RequestBody  AnimeCharacter character) {
		if( character == null) {
			return ResponseEntity.badRequest().body("cannot create character with empty fields");
		}
		return ResponseEntity.ok(charcterRepository.save(character));
	}
	
	/*suppression*/
	@DeleteMapping("/{idAnime}")
	public ResponseEntity deleteCharacter(@PathVariable (name="idAnime") Long idCharacter) {
		if( idCharacter == null) {
			return ResponseEntity.badRequest().body("cannot remove character with null ID");
		}
		
		AnimeCharacter character = charcterRepository.getOne(idCharacter);
		
		 if(character == null) {
			
			 return ResponseEntity.notFound().build();
		 }
		charcterRepository.delete(character);
		return ResponseEntity.ok("Character removed with success ");
	}
	
}
