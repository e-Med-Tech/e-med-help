package com.example.e_med_help.services;

import com.example.e_med_help.models.PrescriptionFile;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.PrescriptionFileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PrescriptionFileServiceImplementation implements PrescriptionFileServiceInterface{

    @Autowired
    PrescriptionFileRepository fileRepository;

    @Autowired
    UsersServiceImplementation usersServiceImplementation;

    @Override
    public void insertPrescriptionFile(PrescriptionFile prescriptionFile) {
        fileRepository.save(prescriptionFile);
    }

    @Override
    public PrescriptionFile findPrescriptionFileByPatient(int id) {
        User user = usersServiceImplementation.getUserById(id);
        return fileRepository.findByFPId(user);
    }

    @Override
    public PrescriptionFile findPrescriptionFileByDoctor(int id) {
        User user = usersServiceImplementation.getUserById(id);
        return fileRepository.findByFDId(user);
    }

    @Override
    public PrescriptionFile findPrescriptionFileByFarmacy(int id) {
        User user = usersServiceImplementation.getUserById(id);
        return fileRepository.findByFFId(user);
    }
}
