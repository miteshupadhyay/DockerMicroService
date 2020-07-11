package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;
import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.service.HelloWorldJPAService;

@RestController
public class HelloWorldJPAController {
	
	@Autowired
	private HelloWorldJPAService helloWorldJPAService;
	
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUniversities(){
		return helloWorldJPAService.findAll();
	}

	@GetMapping("/jpa/users/{userId}")
	public User retrieveUser(@PathVariable int userId) {
		Optional<User> user = helloWorldJPAService.findById(userId);
		return user.get();
	}
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = helloWorldJPAService.save(user);
		
		URI uri = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getUserId())
						.toUri();		
		return ResponseEntity.created(uri).build();		
		
	}
	
}
