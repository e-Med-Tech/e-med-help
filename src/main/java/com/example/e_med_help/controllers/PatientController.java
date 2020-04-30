package com.example.e_med_help.controllers;

import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.services.MedFilesServiceInterface;
import com.example.e_med_help.services.UsersServiceImplementation;
import com.example.e_med_help.utils.CreatePDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/patient")
@Controller
public class PatientController {

    @Autowired
    UsersServiceImplementation usersServiceImplementation;

    @Autowired
    MedFilesServiceInterface medFilesServiceInterface;

    @GetMapping("/home")
    public String goHome() {
        return "patient";
    }

    @GetMapping("/payment")
    public String goHome1() { return "mypayment"; }



//    @GetMapping("/home")
//    public String setMedFile(Model model) {
//        model.addAttribute("myfile", new MedFileDto());
//        return "patient";
//    }

    @PostMapping("/file")
    public String getMedicalHistoty(
            @RequestParam("userPdf") MultipartFile userPdf,
            @RequestParam("username") String username,
            @RequestParam("usersurname") String usersurname,
            @RequestParam("userId") int userId,
            @RequestParam("userText") String userText,
            ModelMap modelMap) {
        String file_name = "MedicalHistory_" + username + "_" + usersurname + ".pdf";
        if (userPdf.isEmpty() && !userText.equals("")) {
            MultipartFile file = new CreatePDF().createMedPDF(username, usersurname, userText);
            MedFile mdFile = new MedFile();
            mdFile.setFUId(usersServiceImplementation.getUserById(userId));
            mdFile.setFUName(username);
            mdFile.setFUSurname(usersurname);
            mdFile.setFFilename(file_name);
            try {
                mdFile.setFData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            medFilesServiceInterface.insertMedFile(mdFile);
        } else if (!userPdf.isEmpty() && userText.equals("")) {
            MedFile mdFilePdf = new MedFile();
            mdFilePdf.setFUId(usersServiceImplementation.getUserById(userId));
            mdFilePdf.setFUName(username);
            mdFilePdf.setFUSurname(usersurname);
            mdFilePdf.setFFilename(userPdf.getOriginalFilename());
            try {
                mdFilePdf.setFData(userPdf.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            medFilesServiceInterface.insertMedFile(mdFilePdf);
        } else if (!userPdf.isEmpty() && !userText.equals("")) {
            MultipartFile fileText = new CreatePDF().createMedPDF(username, usersurname, userText);
            MedFile mdText = new MedFile();
            MedFile mdPdf = new MedFile();
            mdText.setFUId(usersServiceImplementation.getUserById(userId));
            mdPdf.setFUId(usersServiceImplementation.getUserById(userId));
            mdText.setFUName(username);
            mdPdf.setFUName(username);
            mdText.setFUSurname(usersurname);
            mdPdf.setFUSurname(usersurname);
            mdText.setFFilename(file_name);
            mdPdf.setFFilename(userPdf.getOriginalFilename());
            try {
                mdText.setFData(fileText.getBytes());
                mdPdf.setFData(userPdf.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            medFilesServiceInterface.insertMedFile(mdText);
            medFilesServiceInterface.insertMedFile(mdPdf);
        }
        return "redirect:/patient/home";
    }
}

