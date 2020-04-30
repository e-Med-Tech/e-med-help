package com.example.e_med_help.controllers;

import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.models.PrescriptionFile;
import com.example.e_med_help.repositiories.PrescriptionFileRepository;
import com.example.e_med_help.services.PrescriptionFileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pharmacist")
@Controller
public class PharmacistController {

    @Autowired
    PrescriptionFileRepository prescriptionFileRepository;

    @Autowired
    PrescriptionFileServiceInterface presetFileService;

    @GetMapping("/home")
    public String goHome() {
        return "pharmacist";
    }

    @GetMapping("/prescription-lists/{id}")
    public String showMed(@PathVariable("id") Integer id, Model model){
        model.addAttribute("prescriptions", prescriptionFileRepository.findByPharmacy(id));
        return  "/prescription-lists";
    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity<Resource> downloadFile1(@PathVariable("id") Integer id) {
        PrescriptionFile f = presetFileService.findPresById(id);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + f.getfFileName());
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(f.getfData().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))//all types of files
                .body(new ByteArrayResource(f.getfData()));
    }
}
