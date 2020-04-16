package com.udemy.angular.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.angular.repositories.IUser;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	
	@Autowired
	private IUser userRepository;
	
	
	/*liste utilisateur*/
	
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(userRepository.findAll());
		
	}

}
