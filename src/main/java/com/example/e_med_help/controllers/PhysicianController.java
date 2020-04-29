package com.example.e_med_help.controllers;

import com.example.e_med_help.dtos.MockUsers;
import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.UsersRepository;
import com.example.e_med_help.services.RolesServiceInterface;
import com.example.e_med_help.utils.MockUsersMethods;
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

    @Autowired
    RolesServiceInterface rolesService;

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
        Role patient = rolesService.getById(1);
        patients = MockUsersMethods.getMockUsers(patient);
        String temp;
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            temp=u.getUSurname()+" "+u.getUSurname();
            MockUsers mock = new MockUsers(u.getUId(),temp);
            patients.add(mock);
        }
        return patients;
    }


}
