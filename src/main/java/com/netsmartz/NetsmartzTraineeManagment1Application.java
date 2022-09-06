package com.netsmartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.netsmartz.Model.User;
import com.netsmartz.Repository.UserRepository;

@SpringBootApplication
public class NetsmartzTraineeManagment1Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(NetsmartzTraineeManagment1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user=new User();
		user.setUsername("Abul");
		user.setEmail("user");
		
		user.setRole("Role_ADMIN");
		user.setPassword(this.bCryptPasswordEncoder.encode("12345"));
		
		userRepo.save(user);
		
	}
	
	

}
