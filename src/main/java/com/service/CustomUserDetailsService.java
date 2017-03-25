package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customeUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = UserService.findbyusername(userName);
		System.out.println("User : "+user);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getState()
	}
	
}