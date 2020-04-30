package com.example.e_med_help.services;


import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.RolesRepository;
import com.example.e_med_help.repositiories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.jws.soap.SOAPBinding;
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

    @Override
    public List<User> getAllPatients() {
        List<User> users = (List<User>) ur.findAll();
        List<User> patients = new ArrayList<>();
        for (User u: users             ) {
            if (u.getURoleId().getRoleId()==1){
                patients.add(u);
            }
        }
        return patients;
    }

    @Override
    public List<MedFile> getMedFiles(Integer id) {
        return (List<MedFile>) ur.findById(id).get().getMedFileCollection();
    }
}
