package com.bunnty.service;

import com.bunnty.model.User;

public interface UserService{
	User findbyId(int id);
	User findbyuserName(String userName);
}