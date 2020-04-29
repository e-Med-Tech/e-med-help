package com.example.e_med_help.services;

import com.example.e_med_help.models.PrescriptionFile;

import java.util.List;

public interface PrescriptionFileServiceInterface {
    void insertPrescriptionFile(PrescriptionFile prescriptionFile);

    List<PrescriptionFile> findPrescriptionFileByPatient(int id);

    List<PrescriptionFile> findPrescriptionFileByDoctor(int id);

    List<PrescriptionFile> findPrescriptionFileByPharmacy(int id);
}
