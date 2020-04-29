package com.example.e_med_help.utils;

import com.example.e_med_help.dtos.MockUsers;
import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MockUsersMethods {

    private static UsersRepository usersRepository;

    public static List<MockUsers> getMockUsers(Role role){
        int id = role.getRoleId();
        List<MockUsers> mockUsers = new ArrayList<>();
        String temp;
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            if (u.getURoleId()==role){
            temp=u.getUSurname()+" "+u.getUSurname();
            MockUsers mock = new MockUsers(u.getUId(),temp);
            mockUsers.add(mock);
            }
        }
        return mockUsers;
    }
}
