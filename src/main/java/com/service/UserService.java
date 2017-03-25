package com.service;

import com.model.User;

public interface UserService{
	User findbyId(int id);
	User findbyuserName(String userName);
}