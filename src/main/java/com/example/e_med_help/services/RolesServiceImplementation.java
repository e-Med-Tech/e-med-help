package com.example.e_med_help.services;

import com.example.e_med_help.models.Role;
import com.example.e_med_help.repositiories.RolesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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