/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.repositiories;

import com.project.eMedHelp.models.Role;
import com.project.eMedHelp.models.User;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Natasa
 */
@Repository
public interface UsersRepository extends CrudRepository<User,Integer>{
    
     User findByULoginname(String uLoginname);
     

    
//    @Query("SELECT u FROM user u where u.uId<>?1 and u.uRoleId=?2")
//    List<User> findCandidatesNotThePresent(int userId, Role role);
    
}
