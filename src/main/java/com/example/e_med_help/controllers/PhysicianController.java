package com.example.e_med_help.controllers;

import com.example.e_med_help.dtos.MockUsers;
import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.models.PrescriptionFile;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.UsersRepository;
import com.example.e_med_help.services.MedFilesServiceInterface;
import com.example.e_med_help.services.PrescriptionFileServiceInterface;
import com.example.e_med_help.services.RolesServiceInterface;
import com.example.e_med_help.services.UsersServiceInterface;
import com.example.e_med_help.utils.CreatePDF;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    PrescriptionFileServiceInterface prescriptionFileServiceInterface;
    @Autowired
    RolesServiceInterface rolesService;
    @Autowired
    MedFilesServiceInterface medFilesService;

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
                temp = u.getUName() + " " + u.getUSurname();
                MockUsers mock = new MockUsers(u.getUId(), temp);
                mockUsers.add(mock);
            }
        }
        return mockUsers;
    }

    @ModelAttribute("pharmacies")
    public List<MockUsers> getListOfPharmacies() {
        List<MockUsers> mocks = new ArrayList<>();
        String temp;
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            if (u.getURoleId().getRoleId() == 3) {
                temp = u.getUName() + " " + u.getUSurname();
                MockUsers mock = new MockUsers(u.getUId(), temp);
                mocks.add(mock);
            }
        }
        return mocks;
    }

    @PostMapping("/prescription")
    public String fillPrescription(
            @RequestParam("doctor") String doctor,//doctor fullname
            @RequestParam("patient") int patient,//patient id
            @RequestParam("pharmacy") int pharmacy,//pharmacy id
            @RequestParam("userId") int userId,//doctor id
            @RequestParam("text") String text,//prescription text
            ModelMap modelMap) {
        User user = userService.getUserById(patient);
        String patint_name = user.getUSurname() + " " + user.getUName(); //patient fullname
        String file_name = "Prescription" + patient + " " + pharmacy + ".pdf";
        if (!text.equals("")) {
            MultipartFile file = new CreatePDF().createPrescriprionPDF(doctor, patint_name, text);
            PrescriptionFile prescription = new PrescriptionFile();
            prescription.setfDId(userService.getUserById(userId));
            prescription.setfPId(userService.getUserById(patient));
            prescription.setfFId(userService.getUserById(pharmacy));
            prescription.setfFileName(file_name);
            try {
                prescription.setfData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            prescriptionFileServiceInterface.insertPrescriptionFile(prescription);
        }
        return "redirect:/physician/home";
    }

    @GetMapping("/medical-history")
    public String showMed(Model model){
        model.addAttribute("patientsList", userService.getAllPatients());
        return  "/medical-history";
    }

    @ResponseBody
    @GetMapping("/loadMedFilesByPatient/{id}")
    public  String loadMedFilesByPatient(@PathVariable("id") int id){
        Gson gson = new Gson();
        return gson.toJson(medFilesService.findByCountry(id));
    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity<Resource> downloadFile1(@PathVariable("id") Integer id) {
        //1.  Φερτε το Entity με βαση το id
        //2.  Επιστρεψτε το byte array του Entity
        MedFile f = medFilesService.getMedFile(id);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + f.getFFilename());
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(f.getFData().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))//all types of files
                .body(new ByteArrayResource(f.getFData()));
    }

}
