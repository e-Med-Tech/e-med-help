package com.example.e_med_help.services;


import com.example.e_med_help.models.User;
import java.util.List;

public interface UsersServiceInterface {
    
    public User getUserByUsername(String username);

    public void insertUser(User user);

  
    
    public User getUserById(Integer id);
    
}
