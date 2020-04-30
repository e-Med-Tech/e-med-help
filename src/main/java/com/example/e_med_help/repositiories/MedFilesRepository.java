package com.example.e_med_help.repositiories;

import com.example.e_med_help.dtos.MedFileEntity;
import com.example.e_med_help.models.MedFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedFilesRepository extends CrudRepository<MedFile,Integer> {

    @Query("select new com.example.e_med_help.dtos.MedFileEntity(fId,fFilename) from MedFile where fUId.uId = :id")
    public List<MedFileEntity> findByCountry(@Param("id") int id);

}
