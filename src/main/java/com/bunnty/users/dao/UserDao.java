package com.bunnty.users.dao;

import com.bunnty.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}