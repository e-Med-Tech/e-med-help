/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.eMedHelp.validators;

import com.project.eMedHelp.dtos.NewUserDto;
import com.project.eMedHelp.services.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Natasa
 */
@Component
public class NewUserDtoValidator implements Validator{
    
  
    @Autowired
    UsersServiceInterface usi;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewUserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewUserDto user = (NewUserDto) target;

        String userName = user.getName();
        String userSurname = user.getSurname();
        String userUsername = user.getUsername();
        String userPassword1 = user.getPassword1();
        String userPassword2 = user.getPassword2();

//        name validation
        for (Character i : userName.toCharArray()) {
            if (!Character.isLetter(i)) {
                errors.rejectValue("name", "name.not.all.chars");
                break;
            }
        }

        if (userName.length()> 40 || userName.length() < 3) {
            errors.rejectValue("name", "name.not.valid.length");
        }

//        surname validation
        for (Character i : userSurname.toCharArray()) {
            if (!Character.isLetter(i)) {
                errors.rejectValue("surname", "surname.not.all.chars");
                break;
            }
        }

        if (userSurname.length() > 40 || userSurname.length() < 3) {
            errors.rejectValue("surname", "surname.not.valid.length");
        }

//        username validation
        if (userUsername.length() > 40 || userUsername.length() < 3) {
            errors.rejectValue("username", "username.not.valid.length");
        }

        if (usi.getUserByUsername(userUsername) != null) {
            errors.rejectValue("username", "username.already.exists");
        }

        for (Character i : userUsername.toCharArray()) {
            if (!Character.isLetter(i) && !Character.isDigit(i)) {
                errors.rejectValue("username", "username.not.valid.chars");
                break;
            }
        }

//        userPasswords validation
        if (userPassword1.length() > 40 || userPassword1.length() < 5) {
            errors.rejectValue("password1", "pass.not.valid.length");
        }

        if (!userPassword1.equals(userPassword2)) {
            errors.rejectValue("password2", "pass.not.match");
        }
    }

}
