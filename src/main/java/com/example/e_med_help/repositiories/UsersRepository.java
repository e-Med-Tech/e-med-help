package com.example.e_med_help.repositiories;

import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User,Integer> {
    
     User findByULoginname(String uLoginname);

}
