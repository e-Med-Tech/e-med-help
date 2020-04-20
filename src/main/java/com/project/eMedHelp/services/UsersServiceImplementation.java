/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.services;


import com.project.eMedHelp.models.User;
import com.project.eMedHelp.repositiories.RolesRepository;
import com.project.eMedHelp.repositiories.UsersRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Natasa
 */

@Service
@Transactional
public class UsersServiceImplementation implements UsersServiceInterface{
    
  @Autowired
    UsersRepository ur;
    @Autowired
    RolesRepository rr;

    @Override
    public User getUserByUsername(String username) {
        return ur.findByULoginname(username);
    }
   

    @Override
    public void insertUser(User user) {
        ur.save(user);
    }

//    @Override
//    public List<User> findCandidatesNotThePresent(Integer userId) {
//        return ur.findCandidatesNotThePresent(userId,rr.findById(2).get());
//    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = ur.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    
}
