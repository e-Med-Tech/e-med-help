package com.example.e_med_help.services;

import com.example.e_med_help.models.Role;
import java.util.List;

public interface RolesServiceInterface {
    
public List<Role> getAllRoles();
    
    public Role getById(Integer id);
    
}
