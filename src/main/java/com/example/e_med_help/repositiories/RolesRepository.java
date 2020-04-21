package com.example.e_med_help.repositiories;

import com.example.e_med_help.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Role,Integer>{
    
}
