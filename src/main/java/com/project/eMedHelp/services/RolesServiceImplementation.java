/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.services;

import com.project.eMedHelp.models.Role;
import com.project.eMedHelp.repositiories.RolesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Natasa
 */

@Service
@Transactional
public class RolesServiceImplementation implements RolesServiceInterface{

   @Autowired
    RolesRepository rr;

    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) rr.findAll();
    }

    @Override
    public Role getById(Integer id) {
        Optional<Role> role = rr.findById(id);

        if (role.isPresent()) {
            return role.get();
        } else {
            return null;
        }
    
}
}