package com.bunnty.service;

import java.util.List;

import com.bunnty.model.UserProfile;

public interface UserProfileService {
 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}