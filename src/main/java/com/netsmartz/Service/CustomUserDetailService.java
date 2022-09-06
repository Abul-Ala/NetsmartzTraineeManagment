package com.netsmartz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.netsmartz.Model.CustomUserDetail;
import com.netsmartz.Model.User;
import com.netsmartz.Repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=this.userRepo.findByemail(username);
	if (user==null) {
		throw new UsernameNotFoundException("no user");
	}
		return new CustomUserDetail(user);
	}
	

}
