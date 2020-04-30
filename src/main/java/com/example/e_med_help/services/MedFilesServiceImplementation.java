package com.example.e_med_help.services;

import com.example.e_med_help.dtos.MedFileEntity;
import com.example.e_med_help.models.MedFile;
import com.example.e_med_help.models.User;
import com.example.e_med_help.repositiories.MedFilesRepository;
import com.example.e_med_help.repositiories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedFilesServiceImplementation implements MedFilesServiceInterface {

    @Autowired
    private MedFilesRepository medFilesRepository;

    @Autowired
    UsersServiceInterface usersServiceInterface;

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

    @Override
    public List<MedFile> getAllMedFilesById(int id) {
        User user = usersServiceInterface.getUserById(id);
        return (List<MedFile>) user.getMedFileCollection();
    }

    @Override
    public List<MedFileEntity> findByCountry(int id) {
        return medFilesRepository.findByCountry(id);
    }
}
