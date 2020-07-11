package com.mitesh.cloud.techlearn.docker.HelloworldRestApiClient.service;

import org.springframework.stereotype.Component;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;

@Component
public interface HelloworldRestApiClientService {

	public User getUserDetailsForUserId(int userId);

}
