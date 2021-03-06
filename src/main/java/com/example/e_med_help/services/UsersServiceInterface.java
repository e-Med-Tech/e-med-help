package com.example.e_med_help.services;


import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;
import java.util.List;

public interface UsersServiceInterface {
    
    User getUserByUsername(String username);

    void insertUser(User user);

    User getUserById(Integer id);

    List<User> getAllPatients();

    List<MedFile> getMedFiles(Integer id);

}
