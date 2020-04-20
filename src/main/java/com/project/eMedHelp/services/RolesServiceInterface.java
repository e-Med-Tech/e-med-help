/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.services;

import com.project.eMedHelp.models.Role;
import java.util.List;

/**
 *
 * @author Natasa
 */
public interface RolesServiceInterface {
    
public List<Role> getAllRoles();
    
    public Role getById(Integer id);
    
}
