/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.validators;


import com.project.eMedHelp.dtos.LoginUserDto;
import com.project.eMedHelp.models.User;
import com.project.eMedHelp.services.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Natasa
 */
@Component
public class LoginUserValidator implements Validator{
    
    @Autowired
    UsersServiceInterface usi;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginUserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginUserDto user = (LoginUserDto) target;

        String userUsername = user.getLousername();
        String userPassword = user.getLopassword();

        User dbUser = usi.getUserByUsername(userUsername);
        if (dbUser == null) {
            errors.rejectValue("lousername", "lousername.not.exist");
        } else {
            if (!passwordEncoder.matches(userPassword, dbUser.getUPassword())) {
                errors.rejectValue("lopassword", "lopassword.not.correct");
            }
        }
    }
    
}
