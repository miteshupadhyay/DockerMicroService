package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;
import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.service.HelloWorldService;

@RestController
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService helloWorldService;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUniversities(){
		return helloWorldService.findAll();
	}

	@GetMapping("/users/{userId}")
	public User retrieveUser(@PathVariable int userId) {
		User user = helloWorldService.findOne(userId);
		return user;
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createUniversity(@RequestBody User user) {
		User savedUser = helloWorldService.save(user);
		
		URI uri = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getUserId())
						.toUri();		
		return ResponseEntity.created(uri).build();		
		
	}
	
}
