package com.example.e_med_help.controllers;

import com.example.e_med_help.dtos.MockUsers;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.UsersRepository;
import com.example.e_med_help.services.RolesServiceInterface;
import com.example.e_med_help.services.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/physician")
@Controller
public class PhysicianController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersServiceInterface userService;

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
        List<MockUsers> mockUsers = new ArrayList<>();
        String temp;
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            if (u.getURoleId().getRoleId() == 1) {
                temp = u.getUSurname() + " " + u.getUSurname();
                MockUsers mock = new MockUsers(u.getUId(), temp);
                mockUsers.add(mock);
            }
        }
        return mockUsers;
    }

    @PostMapping("/prescription")
    public String getMedicalHistoty(
            @RequestParam("doctor") String doctor,//doctor name
            @RequestParam("patient") int patient,//patient name
            @RequestParam("userId") int userId,//doctor id
            @RequestParam("text") String text,//prescription text
            ModelMap modelMap) {

        User user = userService.getUserById(patient);
        String patint_name = user.getUSurname()+" "+user.getUName();

        System.out.println(doctor);
        System.out.println(userId);
        System.out.println(user.getUName());
        System.out.println(patint_name);
        System.out.println("-----");
        System.out.println("Text");
        System.out.println(text);
        System.out.println(text.equals(""));
        System.out.println(!text.equals(""));


        String file_name = "Prescription" + patient + ".pdf";
        System.out.println(file_name);

//     if (!text.equals("")) {
//        MedFile mdFilePdf = new MedFile();
//        mdFilePdf.setFUId(usersServiceImplementation.getUserById(userId));
//        mdFilePdf.setFUName(username);
//        mdFilePdf.setFUSurname(usersurname);
//        mdFilePdf.setFFilename(userPdf.getOriginalFilename());
//        try {
//            mdFilePdf.setFData(userPdf.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        medFilesServiceInterface.insertMedFile(mdFilePdf);
//    } else {
//    }
        System.out.println("Success01");
        return "redirect:/physician/home";
    }

}
