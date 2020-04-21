package com.example.e_med_help.services;

import com.example.e_med_help.models.MedFile;

import java.util.List;

public interface MedFilesServiceInterface {
    public List<MedFile> getAllMedFiles();
    public void insertMedFile(MedFile medFile);
//    TODO getfile
}
