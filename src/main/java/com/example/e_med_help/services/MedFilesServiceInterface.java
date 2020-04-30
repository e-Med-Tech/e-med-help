package com.example.e_med_help.services;

import com.example.e_med_help.dtos.MedFileEntity;
import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.repositiories.MedFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MedFilesServiceInterface {


    List<MedFile> getAllMedFiles();
    void insertMedFile(MedFile medFile);
    MedFile getMedFile(Integer id);
    List<MedFile> getAllMedFilesById(int id);

    List<MedFileEntity> findByCountry(int id);
}
