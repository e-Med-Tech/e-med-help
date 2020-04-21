package com.example.e_med_help.repositiories;

import com.example.e_med_help.models.MedFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedFilesRepository extends CrudRepository<MedFile,Integer> {
}
