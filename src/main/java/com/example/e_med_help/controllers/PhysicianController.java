package com.example.e_med_help.controllers;

import com.example.e_med_help.dtos.MockUsers;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/physician")
@Controller
public class PhysicianController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/home")
    public String goHome() {
        return "physician";
    }


    @GetMapping("/prescription")
    public String showPrescription(Model model) {
        return "prescription";
    }

    @ModelAttribute("patients")
    public List<MockUsers> getListOfRoles() {
        List<MockUsers> patients = new ArrayList<>();
        String temp;
        List<User> users = usersRepository.findAll();
        for (User u : users) {
            temp=u.getUSurname()+" "+u.getUSurname();
            MockUsers mock = new MockUsers(u.getUId(),temp);
            patients.add(mock);
        }
        return patients;
    }


}
