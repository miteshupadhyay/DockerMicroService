package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean.User;

public interface HelloWorldJPARepository extends JpaRepository<User, Integer>{

}
