/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.services;


import com.project.eMedHelp.models.User;
import java.util.List;

/**
 *
 * @author Natasa
 */
public interface UsersServiceInterface {
    
    public User getUserByUsername(String username);

    public void insertUser(User user);

  
    
    public User getUserById(Integer id);
    
}
