package com.bunnty.dao;

import com.bunnty.model.User;

public interface UserDao{
	User findById(int id);
	User findByuserName(String userName);
}