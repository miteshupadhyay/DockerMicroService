package com.mitesh.cloud.techlearn.docker.HelloworldRestApiClient.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiClient.impl.HelloworldRestApiClientServiceImpl;
import com.mitesh.cloud.techlearn.docker.HelloworldRestApiClient.service.HelloworldRestApiClientService;
import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;

@RestController
public class HelloworldRestApiClientController {

	@Autowired
	private HelloworldRestApiClientServiceImpl helloworldRestApiClientServiceImpl;

	
	@GetMapping("/jpa/users/{userId}")
	public User retrieveUser(@PathVariable int userId) {
		User user = helloworldRestApiClientServiceImpl.getUserDetailsForUserId(userId);
		return user;
	}
}

