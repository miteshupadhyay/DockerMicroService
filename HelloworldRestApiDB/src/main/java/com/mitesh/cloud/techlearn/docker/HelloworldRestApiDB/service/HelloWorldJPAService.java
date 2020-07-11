package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.Repository.HelloWorldJPARepository;
import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;

@Component
public class HelloWorldJPAService {

	private static List<User> users = new ArrayList<User>();

	@Autowired
	private HelloWorldJPARepository helloWorldJPARepository;
	
	
	

	public List<User> findAll() {
		return helloWorldJPARepository.findAll();
	}

	public User save(User user){
		User userSaved = helloWorldJPARepository.save(user);
		return userSaved;		
	}

	public Optional<User> findById(int userId) {
		Optional<User> user = helloWorldJPARepository.findById(userId);
		return user;
	}
}
