package com.example.e_med_help.services;

import com.example.e_med_help.models.Role;
import java.util.List;

public interface RolesServiceInterface {
    
List<Role> getAllRoles();
    
    Role getById(Integer id);
    
}
