package com.example.e_med_help.services;

import com.example.e_med_help.models.PrescriptionFile;

public interface PrescriptionFileServiceInterface {
    void insertPrescriptionFile(PrescriptionFile prescriptionFile);
    PrescriptionFile findPrescriptionFileByPatient(int id);
    PrescriptionFile findPrescriptionFileByDoctor(int id);
    PrescriptionFile findPrescriptionFileByFarmacy(int id);
}
