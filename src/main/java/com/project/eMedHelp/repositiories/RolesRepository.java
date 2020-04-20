/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.repositiories;

import com.project.eMedHelp.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Natasa
 */
@Repository
public interface RolesRepository extends CrudRepository<Role,Integer>{
    
}
