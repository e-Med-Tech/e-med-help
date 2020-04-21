package com.example.e_med_help.services;

import com.example.e_med_help.models.MedFile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MedFilesServiceImplementation implements MedFilesServiceInterface {
    @Override
    public List<MedFile> getAllMedFiles() {
//        TODO
        return null;
    }

    @Override
    public void insertMedFile(MedFile medFile) {
//        TODO

    }
}
