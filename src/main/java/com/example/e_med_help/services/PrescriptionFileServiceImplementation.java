package com.example.e_med_help.services;

import com.example.e_med_help.models.PrescriptionFile;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.PrescriptionFileRepository;
import com.example.e_med_help.repositiories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PrescriptionFileServiceImplementation implements PrescriptionFileServiceInterface {

    @Autowired
    PrescriptionFileRepository fileRepository;

    @Autowired
    UsersServiceInterface usersService;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void insertPrescriptionFile(PrescriptionFile prescriptionFile) {
        fileRepository.save(prescriptionFile);
    }

    @Override
    public List<PrescriptionFile> findPrescriptionFileByPatient(int id) {
        List<PrescriptionFile> files = new ArrayList<>();
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            if (u.getURoleId().getRoleId() == 1 && u.getUId() == id) {
                files = (List<PrescriptionFile>) u.getPrescriptionFileCollection();
            }
        }
        return files;
    }

    @Override
    public List<PrescriptionFile> findPrescriptionFileByDoctor(int id) {
        List<PrescriptionFile> files = new ArrayList<>();
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            if (u.getURoleId().getRoleId() == 2 && u.getUId() == id) {
                files = (List<PrescriptionFile>) u.getPrescriptionFileCollection();
            }
        }
        return files;
    }

    @Override
    public List<PrescriptionFile> findPrescriptionFileByPharmacy(int id) {
        List<PrescriptionFile> files = new ArrayList<>();
        List<User> users = (List<User>) usersRepository.findAll();
        for (User u : users) {
            if (u.getURoleId().getRoleId() == 3 && u.getUId() == id) {
                files = (List<PrescriptionFile>) u.getPrescriptionFileCollection();
            }
        }
        return files;
    }


}
