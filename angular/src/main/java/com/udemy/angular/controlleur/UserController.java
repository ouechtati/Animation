package com.udemy.angular.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.angular.entities.User;
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
	
	/*récupération d'un utilisateur*/
	@GetMapping("/{idUser}")
	public ResponseEntity findUserById (@PathVariable(name="idUser")Long idUser) {
		if(idUser == null) {
			return ResponseEntity.badRequest().body("cannot retrive user with null ID");
		}
		
		User  user = userRepository.getOne(idUser);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}

	/*création d'un utilisateur*/
	@PostMapping("/")
	public ResponseEntity createUser(@RequestBody User user) {
		
		if(user == null) {
			return ResponseEntity.badRequest().body("cannot create user with empty fileds");
		}
		 User createUser =userRepository.save(user);
		 return ResponseEntity.ok(createUser);
		
		
	}
	
	/*création d'un login*/
	@PostMapping("/login")
	public ResponseEntity login(@RequestParam (name="mail") String mail,@RequestParam (name="password") String password) {
		
if (StringUtils.isEmpty(mail) ||StringUtils.isEmpty(password)) {
	return ResponseEntity.badRequest().body("cannot login with empty mail or password");
}

   User authenticateUser = userRepository.findByMailAndPassword(mail, password);
   if(authenticateUser == null) {
	   return ResponseEntity.notFound().build();
   }
		return ResponseEntity.ok(authenticateUser);
		
	}
}
