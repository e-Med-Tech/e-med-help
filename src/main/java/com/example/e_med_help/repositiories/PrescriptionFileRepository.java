package com.example.e_med_help.repositiories;

import com.example.e_med_help.dtos.MedFileEntity;
import com.example.e_med_help.dtos.PrescriptionEntity;
import com.example.e_med_help.models.PrescriptionFile;
import com.example.e_med_help.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionFileRepository extends CrudRepository<PrescriptionFile, Integer> {

//    PrescriptionFile findByFDId(User user);
//    PrescriptionFile findByFPId(User user);
//    PrescriptionFile findByFFId(User user);

    @Query("select new com.example.e_med_help.dtos.PrescriptionEntity(fId,fFileName) from PrescriptionFile where fFId.uId = :id")
    public List<PrescriptionEntity> findByPharmacy(@Param("id") int id);

    @Query("select new com.example.e_med_help.dtos.PrescriptionEntity(fId,fFileName) from PrescriptionFile where fPId.uId = :id")
    public List<PrescriptionEntity> findByPatient(@Param("id") int id);




}


