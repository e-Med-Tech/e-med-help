package com.example.e_med_help.services;

import com.example.e_med_help.models.MedFile;

import java.util.List;

public interface MedFilesServiceInterface {

    List<MedFile> getAllMedFiles();
    void insertMedFile(MedFile medFile);
    MedFile getMedFile(Integer id);
}
