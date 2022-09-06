package com.netsmartz.Repository;

import org.springframework.data.repository.CrudRepository;

import com.netsmartz.Model.User;

public interface UserRepository extends CrudRepository<User,Integer>{

 public User findByemail(String userEmail);

	

}
