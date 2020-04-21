package com.example.e_med_help.repositiories;

import com.example.e_med_help.models.Role;
import com.example.e_med_help.models.User;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User,Integer>{
    
     User findByULoginname(String uLoginname);
     

    
//    @Query("SELECT u FROM user u where u.uId<>?1 and u.uRoleId=?2")
//    List<User> findCandidatesNotThePresent(int userId, Role role);
    
}
