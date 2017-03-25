package com.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	
	public User findbyId(int id){
		return dao.findById(id);
	}
	public User findbyuserName(String userName){
		return dao.findByuserName(userName);
	}
}