package com.example.e_med_help.services;

import com.example.e_med_help.models.PrescriptionFile;
import com.example.e_med_help.repositiories.PrescriptionFileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PrescriptionFileServiceImplementation implements PrescriptionFileServiceInterface{

    @Autowired
    PrescriptionFileRepository fileRepository;
    
    @Override
    public void insertPrescriptionFile(PrescriptionFile prescriptionFile) {
        fileRepository.save(prescriptionFile);
    }
}
