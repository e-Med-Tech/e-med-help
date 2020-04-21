package com.example.e_med_help.services;


import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.RolesRepository;
import com.example.e_med_help.repositiories.UsersRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = ur.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    
}
