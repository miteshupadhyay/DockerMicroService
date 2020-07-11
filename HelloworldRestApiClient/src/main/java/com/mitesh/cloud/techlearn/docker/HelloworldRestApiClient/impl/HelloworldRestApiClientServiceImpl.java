package com.mitesh.cloud.techlearn.docker.HelloworldRestApiClient.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiClient.service.HelloworldRestApiClientService;
import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;

@Component
public class HelloworldRestApiClientServiceImpl implements HelloworldRestApiClientService {

	public User getUserDetailsForUserId(int userId)
	{
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<User> userEntity = restTemplate.getForEntity("http://localhost:8000/jpa/users/"+userId, User.class);
		return userEntity.getBody();
	}
	
}
