package com.example.e_med_help.services;

import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.repositiories.MedFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MedFilesServiceImplementation implements MedFilesServiceInterface {

    @Autowired
    MedFilesRepository medFilesRepository;

    @Override
    public List<MedFile> getAllMedFiles() {
        return (List<MedFile>) medFilesRepository.findAll();
    }

    @Override
    public void insertMedFile(MedFile medFile) {
        medFilesRepository.save(medFile);
    }

    @Override
    public MedFile getMedFile(Integer id) {
        return medFilesRepository.findById(id).get();
    }
}
