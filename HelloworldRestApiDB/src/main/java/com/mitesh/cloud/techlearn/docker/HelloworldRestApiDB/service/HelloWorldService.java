package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;

@Component
public class HelloWorldService {

	private static List<User> users = new ArrayList<User>();

	private static int userCount = 3;

	static {
		users.add(new User(101, "Mitesh","Indore"));
		users.add(new User(201, "Sumit","Bhopal"));
		users.add(new User(301, "Abhishek","Jaipur"));
	}
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		Integer userId = user.getUserId();
		if (userId==null || userId==0) {
			user.setUserId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getUserId()== id) {
				return user;
			}
		}
		return null;
	}
}
